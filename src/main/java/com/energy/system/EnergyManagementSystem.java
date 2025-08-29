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
        this.pricingStrategy = newStrategy;
        System.out.println("استراتژی قیمت‌گذاری به " + newStrategy.getStrategyName() + " تغییر یافت");
    }
    
    public void changeSystemState(EnergySystemState newState) {
        EnergySystemState oldState = this.currentState;
        this.currentState = newState;
        
        System.out.println("وضعیت سیستم از " + oldState.getStateName() + 
                          " به " + newState.getStateName() + " تغییر یافت");
        System.out.println("توضیح وضعیت جدید: " + newState.getStateDescription());
        System.out.println("نرخ مصرف انرژی: " + newState.getEnergyConsumptionRate() + " واحد در ساعت");
    }
    
    public PricingStrategy getCurrentPricingStrategy() {
        return pricingStrategy;
    }
    
    public EnergySystemState getCurrentState() {
        return currentState;
    }
    
    public int getTotalEnergyConsumed() {
        return totalEnergyConsumed;
    }
    
    public void simulateEnergyConsumption(int hours) {
        int energyConsumed = currentState.getEnergyConsumptionRate() * hours;
        totalEnergyConsumed += energyConsumed;
        
        System.out.println(hours + " ساعت کار شبیه‌سازی شد");
        System.out.println("انرژی مصرف شده: " + energyConsumed + " واحد");
        System.out.println("کل انرژی مصرف شده: " + totalEnergyConsumed + " واحد");
    }
    
    public double calculateTotalCost() {
        return pricingStrategy.calculateCost(totalEnergyConsumed);
    }
    
    public double simulateCost(int energyUnits) {
        return pricingStrategy.calculateCost(energyUnits);
    }
    
    public void displayStatus() {
        System.out.println("\n=== وضعیت فعلی سیستم ===");
        System.out.println("وضعیت سیستم: " + currentState.getStateName());
        System.out.println("توضیح وضعیت: " + currentState.getStateDescription());
        System.out.println("نرخ مصرف انرژی: " + currentState.getEnergyConsumptionRate() + " واحد در ساعت");
        System.out.println("استراتژی قیمت‌گذاری: " + pricingStrategy.getStrategyName());
        System.out.println("قیمت هر واحد: " + pricingStrategy.getPricePerUnit() + " تومان");
        System.out.println("کل انرژی مصرف شده: " + totalEnergyConsumed + " واحد");
        System.out.println("هزینه کل: " + calculateTotalCost() + " تومان");
        System.out.println("=============================\n");
    }
}
