package com.energy.strategy;

public interface PricingStrategy {
    
    double calculateCost(int energyUnits);
    
    String getStrategyName();
    
    double getPricePerUnit();
    
    String getPricingCategory();
}
