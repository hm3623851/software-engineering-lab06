package com.energy.calculator;

import com.energy.strategy.PricingStrategy;

public class PricingCalculator {
    
    public static double calculateCostWithDiscount(PricingStrategy strategy, int energyUnits, double discountRate) {
        double baseCost = strategy.calculateCost(energyUnits);
        return baseCost * (1 - discountRate);
    }
    
    public static String getPricingDescription(PricingStrategy strategy) {
        return strategy.getPricingCategory() + " - " + strategy.getStrategyName() + 
               " (" + strategy.getPricePerUnit() + " تومان/واحد)";
    }
    
    public static boolean isEcoFriendly(PricingStrategy strategy) {
        return "GREEN".equals(strategy.getPricingCategory());
    }
}
