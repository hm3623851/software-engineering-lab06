package com.energy.strategy;

public class StandardPricingStrategy implements PricingStrategy {
    
    private static final double PRICE_PER_UNIT = 500.0;
    
    @Override
    public double calculateCost(int energyUnits) {
        return energyUnits * PRICE_PER_UNIT;
    }
    
    @Override
    public String getStrategyName() {
        return "استاندارد";
    }
    
    @Override
    public double getPricePerUnit() {
        return PRICE_PER_UNIT;
    }
}
