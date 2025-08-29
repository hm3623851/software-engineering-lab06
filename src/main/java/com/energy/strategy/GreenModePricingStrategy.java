package com.energy.strategy;

public class GreenModePricingStrategy implements PricingStrategy {
    
    private static final double PRICE_PER_UNIT = 300.0;
    
    @Override
    public double calculateCost(int energyUnits) {
        return energyUnits * PRICE_PER_UNIT;
    }
    
    @Override
    public String getStrategyName() {
        return "حالت سبز";
    }
    
    @Override
    public double getPricePerUnit() {
        return PRICE_PER_UNIT;
    }
}
