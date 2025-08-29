package com.energy.strategy;

import com.energy.constants.EnergyConstants;

public class GreenModePricingStrategy implements PricingStrategy {
    
    @Override
    public double calculateCost(int energyUnits) {
        return energyUnits * EnergyConstants.GREEN_MODE_PRICE_PER_UNIT;
    }
    
    @Override
    public String getStrategyName() {
        return "حالت سبز";
    }
    
    @Override
    public double getPricePerUnit() {
        return EnergyConstants.GREEN_MODE_PRICE_PER_UNIT;
    }
    
    @Override
    public String getPricingCategory() {
        return EnergyConstants.GREEN_CATEGORY;
    }
}
