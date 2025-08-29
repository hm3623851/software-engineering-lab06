package com.energy.strategy;

import com.energy.constants.EnergyConstants;

public class StandardPricingStrategy implements PricingStrategy {
    
    @Override
    public double calculateCost(int energyUnits) {
        return energyUnits * EnergyConstants.STANDARD_PRICE_PER_UNIT;
    }
    
    @Override
    public String getStrategyName() {
        return "استاندارد";
    }
    
    @Override
    public double getPricePerUnit() {
        return EnergyConstants.STANDARD_PRICE_PER_UNIT;
    }
    
    @Override
    public String getPricingCategory() {
        return EnergyConstants.STANDARD_CATEGORY;
    }
}
