package com.energy.strategy;

import org.junit.Test;
import static org.junit.Assert.*;

public class PricingStrategyTest {
    
    @Test
    public void testStandardPricingStrategy() {
        PricingStrategy strategy = new StandardPricingStrategy();
        
        assertEquals("استاندارد", strategy.getStrategyName());
        assertEquals(500.0, strategy.getPricePerUnit(), 0.001);
        
        assertEquals(0.0, strategy.calculateCost(0), 0.001);
        assertEquals(500.0, strategy.calculateCost(1), 0.001);
        assertEquals(1000.0, strategy.calculateCost(2), 0.001);
        assertEquals(5000.0, strategy.calculateCost(10), 0.001);
    }
    
    @Test
    public void testPeakHoursPricingStrategy() {
        PricingStrategy strategy = new PeakHoursPricingStrategy();
        
        assertEquals("ساعات اوج مصرف", strategy.getStrategyName());
        assertEquals(1000.0, strategy.getPricePerUnit(), 0.001);
        
        assertEquals(0.0, strategy.calculateCost(0), 0.001);
        assertEquals(1000.0, strategy.calculateCost(1), 0.001);
        assertEquals(2000.0, strategy.calculateCost(2), 0.001);
        assertEquals(10000.0, strategy.calculateCost(10), 0.001);
    }
    
    @Test
    public void testGreenModePricingStrategy() {
        PricingStrategy strategy = new GreenModePricingStrategy();
        
        assertEquals("حالت سبز", strategy.getStrategyName());
        assertEquals(300.0, strategy.getPricePerUnit(), 0.001);
        
        assertEquals(0.0, strategy.calculateCost(0), 0.001);
        assertEquals(300.0, strategy.calculateCost(1), 0.001);
        assertEquals(600.0, strategy.calculateCost(2), 0.001);
        assertEquals(3000.0, strategy.calculateCost(10), 0.001);
    }
    
    @Test
    public void testStrategyPatternBehavior() {
        PricingStrategy[] strategies = {
            new StandardPricingStrategy(),
            new PeakHoursPricingStrategy(),
            new GreenModePricingStrategy()
        };
        
        int testEnergyUnits = 5;
        
        for (PricingStrategy strategy : strategies) {
            double cost = strategy.calculateCost(testEnergyUnits);
            double expectedCost = testEnergyUnits * strategy.getPricePerUnit();
            
            assertEquals(expectedCost, cost, 0.001);
            assertTrue(cost >= 0);
        }
    }
}
