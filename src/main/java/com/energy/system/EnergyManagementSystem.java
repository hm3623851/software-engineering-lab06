package com.energy.system;

import com.energy.strategy.PricingStrategy;
import com.energy.strategy.StandardPricingStrategy;
import com.energy.state.EnergySystemState;
import com.energy.state.ActiveState;

public class EnergyManagementSystem {
    
    private PricingStrategy pricingStrategy;
    private EnergySystemState currentState;
    private int totalEnergyConsumed;
    
    public EnergyManagementSystem() {
        this.pricingStrategy = new StandardPricingStrategy();
        this.currentState = new ActiveState();
        this.totalEnergyConsumed = 0;
    }
    
    public void changePricingStrategy(PricingStrategy newStrategy) {
        setPricingStrategy(newStrategy);
        System.out.println("استراتژی قیمت‌گذاری به " + getPricingStrategyInternal().getStrategyName() + " تغییر یافت");
    }
    
    public void changeSystemState(EnergySystemState newState) {
        EnergySystemState oldState = getCurrentStateInternal();
        setCurrentState(newState);
        
        System.out.println("وضعیت سیستم از " + oldState.getStateName() + 
                          " به " + getCurrentStateInternal().getStateName() + " تغییر یافت");
        System.out.println("توضیح وضعیت جدید: " + getCurrentStateInternal().getStateDescription());
        System.out.println("نرخ مصرف انرژی: " + getCurrentStateInternal().getEnergyConsumptionRate() + " واحد در ساعت");
    }
    
    public PricingStrategy getCurrentPricingStrategy() {
        return getPricingStrategyInternal();
    }
    
    public EnergySystemState getCurrentState() {
        return getCurrentStateInternal();
    }
    
    public int getTotalEnergyConsumed() {
        return getTotalEnergyConsumedInternal();
    }
    
    public void simulateEnergyConsumption(int hours) {
        int energyConsumed = getCurrentStateInternal().getEnergyConsumptionRate() * hours;
        setTotalEnergyConsumed(getTotalEnergyConsumedInternal() + energyConsumed);
        
        System.out.println(hours + " ساعت کار شبیه‌سازی شد");
        System.out.println("انرژی مصرف شده: " + energyConsumed + " واحد");
        System.out.println("کل انرژی مصرف شده: " + getTotalEnergyConsumedInternal() + " واحد");
    }
    
    public double calculateTotalCost() {
        return getPricingStrategyInternal().calculateCost(getTotalEnergyConsumedInternal());
    }
    
    public double simulateCost(int energyUnits) {
        return getPricingStrategyInternal().calculateCost(energyUnits);
    }
    
    public void displayStatus() {
        System.out.println("\n=== وضعیت فعلی سیستم ===");
        System.out.println("وضعیت سیستم: " + getCurrentStateInternal().getStateName());
        System.out.println("توضیح وضعیت: " + getCurrentStateInternal().getStateDescription());
        System.out.println("نرخ مصرف انرژی: " + getCurrentStateInternal().getEnergyConsumptionRate() + " واحد در ساعت");
        System.out.println("استراتژی قیمت‌گذاری: " + getPricingStrategyInternal().getStrategyName());
        System.out.println("قیمت هر واحد: " + getPricingStrategyInternal().getPricePerUnit() + " تومان");
        System.out.println("کل انرژی مصرف شده: " + getTotalEnergyConsumedInternal() + " واحد");
        System.out.println("هزینه کل: " + calculateTotalCost() + " تومان");
        System.out.println("=============================\n");
    }
    
    public String getStatusReport() {
        return "وضعیت: " + getCurrentStateInternal().getStateName() + 
               ", استراتژی: " + getPricingStrategyInternal().getStrategyName() + 
               ", مصرف: " + getTotalEnergyConsumedInternal() + " واحد";
    }
    
    public void resetEnergyConsumption() {
        setTotalEnergyConsumed(0);
    }
    
    private PricingStrategy getPricingStrategyInternal() {
        return pricingStrategy;
    }
    
    private void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
    
    private EnergySystemState getCurrentStateInternal() {
        return currentState;
    }
    
    private void setCurrentState(EnergySystemState currentState) {
        this.currentState = currentState;
    }
    
    private int getTotalEnergyConsumedInternal() {
        return totalEnergyConsumed;
    }
    
    private void setTotalEnergyConsumed(int totalEnergyConsumed) {
        this.totalEnergyConsumed = totalEnergyConsumed;
    }
}
