package com.energy.strategy;

import com.energy.constants.EnergyConstants;

public class PeakHoursPricingStrategy implements PricingStrategy {
    
    @Override
    public double calculateCost(int energyUnits) {
        return energyUnits * EnergyConstants.PEAK_HOURS_PRICE_PER_UNIT;
    }
    
    @Override
    public String getStrategyName() {
        return "ساعات اوج مصرف";
    }
    
    @Override
    public double getPricePerUnit() {
        return EnergyConstants.PEAK_HOURS_PRICE_PER_UNIT;
    }
    
    @Override
    public String getPricingCategory() {
        return EnergyConstants.PEAK_CATEGORY;
    }
}
