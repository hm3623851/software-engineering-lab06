package com.energy.facade;

import com.energy.strategy.PricingStrategy;
import com.energy.state.EnergySystemState;
import com.energy.system.EnergyManagementSystem;

public class EnergyManagementFacade {
    
    private EnergyManagementSystem energySystem;
    
    public EnergyManagementFacade() {
        this.energySystem = new EnergyManagementSystem();
    }
    
    public void initializeSystem() {
        energySystem.displayStatus();
    }
    
    public void switchToEcoMode() {
        energySystem.changeSystemState(new com.energy.state.EcoModeState());
        energySystem.changePricingStrategy(new com.energy.strategy.GreenModePricingStrategy());
    }
    
    public void switchToPeakHours() {
        energySystem.changePricingStrategy(new com.energy.strategy.PeakHoursPricingStrategy());
    }
    
    public void simulateFullDayOperation() {
        energySystem.simulateEnergyConsumption(24);
    }
    
    public double getCurrentCost() {
        return energySystem.calculateTotalCost();
    }
    
    public String getSystemSummary() {
        return "وضعیت: " + energySystem.getCurrentState().getStateName() + 
               ", استراتژی: " + energySystem.getCurrentPricingStrategy().getStrategyName() + 
               ", هزینه: " + energySystem.calculateTotalCost() + " تومان";
    }
    
    public EnergyManagementSystem getSystem() {
        return energySystem;
    }
}
