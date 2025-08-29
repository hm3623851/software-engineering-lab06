package com.energy.strategy;

public class PeakHoursPricingStrategy implements PricingStrategy {
    
    private static final double PRICE_PER_UNIT = 1000.0;
    
    @Override
    public double calculateCost(int energyUnits) {
        return energyUnits * PRICE_PER_UNIT;
    }
    
    @Override
    public String getStrategyName() {
        return "ساعات اوج مصرف";
    }
    
    @Override
    public double getPricePerUnit() {
        return PRICE_PER_UNIT;
    }
}
