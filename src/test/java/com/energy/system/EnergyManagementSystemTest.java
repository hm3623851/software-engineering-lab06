package com.energy.system;

import com.energy.strategy.*;
import com.energy.state.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EnergyManagementSystemTest {
    
    private EnergyManagementSystem energySystem;
    
    @Before
    public void setUp() {
        energySystem = new EnergyManagementSystem();
    }
    
    @Test
    public void testInitialState() {
        assertTrue(energySystem.getCurrentPricingStrategy() instanceof StandardPricingStrategy);
        assertTrue(energySystem.getCurrentState() instanceof ActiveState);
        assertEquals(0, energySystem.getTotalEnergyConsumed());
    }
    
    @Test
    public void testChangePricingStrategy() {
        PricingStrategy peakStrategy = new PeakHoursPricingStrategy();
        energySystem.changePricingStrategy(peakStrategy);
        
        assertEquals(peakStrategy, energySystem.getCurrentPricingStrategy());
        assertEquals("ساعات اوج مصرف", energySystem.getCurrentPricingStrategy().getStrategyName());
        assertEquals(1000.0, energySystem.getCurrentPricingStrategy().getPricePerUnit(), 0.001);
        
        PricingStrategy greenStrategy = new GreenModePricingStrategy();
        energySystem.changePricingStrategy(greenStrategy);
        
        assertEquals(greenStrategy, energySystem.getCurrentPricingStrategy());
        assertEquals("حالت سبز", energySystem.getCurrentPricingStrategy().getStrategyName());
        assertEquals(300.0, energySystem.getCurrentPricingStrategy().getPricePerUnit(), 0.001);
    }
    
    @Test
    public void testChangeSystemState() {
        EnergySystemState ecoState = new EcoModeState();
        energySystem.changeSystemState(ecoState);
        
        assertEquals(ecoState, energySystem.getCurrentState());
        assertEquals("حالت اقتصادی", energySystem.getCurrentState().getStateName());
        assertEquals(4, energySystem.getCurrentState().getEnergyConsumptionRate());
        
        EnergySystemState shutdownState = new ShutdownState();
        energySystem.changeSystemState(shutdownState);
        
        assertEquals(shutdownState, energySystem.getCurrentState());
        assertEquals("خاموش", energySystem.getCurrentState().getStateName());
        assertEquals(0, energySystem.getCurrentState().getEnergyConsumptionRate());
    }
    
    @Test
    public void testEnergyConsumptionSimulation() {
        energySystem.simulateEnergyConsumption(2);
        assertEquals(20, energySystem.getTotalEnergyConsumed());
        
        energySystem.changeSystemState(new EcoModeState());
        energySystem.simulateEnergyConsumption(3);
        assertEquals(32, energySystem.getTotalEnergyConsumed());
        
        energySystem.changeSystemState(new ShutdownState());
        energySystem.simulateEnergyConsumption(5);
        assertEquals(32, energySystem.getTotalEnergyConsumed());
    }
    
    @Test
    public void testCostCalculation() {
        energySystem.simulateEnergyConsumption(1);
        assertEquals(5000.0, energySystem.calculateTotalCost(), 0.001);
        
        energySystem.changePricingStrategy(new PeakHoursPricingStrategy());
        assertEquals(10000.0, energySystem.calculateTotalCost(), 0.001);
        
        energySystem.changePricingStrategy(new GreenModePricingStrategy());
        assertEquals(3000.0, energySystem.calculateTotalCost(), 0.001);
    }
    
    @Test
    public void testSimulateCost() {
        assertEquals(0.0, energySystem.simulateCost(0), 0.001);
        assertEquals(500.0, energySystem.simulateCost(1), 0.001);
        assertEquals(1000.0, energySystem.simulateCost(2), 0.001);
        assertEquals(5000.0, energySystem.simulateCost(10), 0.001);
        
        energySystem.changePricingStrategy(new PeakHoursPricingStrategy());
        assertEquals(0.0, energySystem.simulateCost(0), 0.001);
        assertEquals(1000.0, energySystem.simulateCost(1), 0.001);
        assertEquals(2000.0, energySystem.simulateCost(2), 0.001);
        assertEquals(10000.0, energySystem.simulateCost(10), 0.001);
    }
    
    @Test
    public void testIntegrationOfPatterns() {
        assertTrue(energySystem.getCurrentState() instanceof ActiveState);
        assertTrue(energySystem.getCurrentPricingStrategy() instanceof StandardPricingStrategy);
        
        energySystem.simulateEnergyConsumption(2);
        assertEquals(20, energySystem.getTotalEnergyConsumed());
        assertEquals(10000.0, energySystem.calculateTotalCost(), 0.001);
        
        energySystem.changeSystemState(new EcoModeState());
        energySystem.changePricingStrategy(new PeakHoursPricingStrategy());
        
        energySystem.simulateEnergyConsumption(3);
        assertEquals(32, energySystem.getTotalEnergyConsumed());
        assertEquals(32000.0, energySystem.calculateTotalCost(), 0.001);
        
        assertEquals("حالت اقتصادی", energySystem.getCurrentState().getStateName());
        assertEquals("ساعات اوج مصرف", energySystem.getCurrentPricingStrategy().getStrategyName());
    }
}
