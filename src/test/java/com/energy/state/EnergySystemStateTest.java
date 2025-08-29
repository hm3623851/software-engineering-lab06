package com.energy.state;

import org.junit.Test;
import static org.junit.Assert.*;

public class EnergySystemStateTest {
    
    @Test
    public void testActiveState() {
        EnergySystemState state = new ActiveState();
        
        assertEquals("فعال", state.getStateName());
        assertEquals(10, state.getEnergyConsumptionRate());
        assertEquals("همه سیستم‌ها با ظرفیت کامل در حال کار هستند", state.getStateDescription());
        
        assertTrue(state.isSystemActive("Heating"));
        assertTrue(state.isSystemActive("Ventilation"));
        assertTrue(state.isSystemActive("Lighting"));
        assertTrue(state.isSystemActive("Emergency Lighting"));
        assertTrue(state.isSystemActive("Low-Consumption Ventilation"));
    }
    
    @Test
    public void testEcoModeState() {
        EnergySystemState state = new EcoModeState();
        
        assertEquals("حالت اقتصادی", state.getStateName());
        assertEquals(4, state.getEnergyConsumptionRate());
        assertEquals("فقط سیستم‌های حیاتی (روشنایی اضطراری و تهویه کم‌مصرف) در حال کار هستند", 
                    state.getStateDescription());
        
        assertFalse(state.isSystemActive("Heating"));
        assertFalse(state.isSystemActive("Ventilation"));
        assertFalse(state.isSystemActive("Lighting"));
        assertTrue(state.isSystemActive("Emergency Lighting"));
        assertTrue(state.isSystemActive("Low-Consumption Ventilation"));
    }
    
    @Test
    public void testShutdownState() {
        EnergySystemState state = new ShutdownState();
        
        assertEquals("خاموش", state.getStateName());
        assertEquals(0, state.getEnergyConsumptionRate());
        assertEquals("همه سیستم‌ها خاموش هستند", state.getStateDescription());
        
        assertFalse(state.isSystemActive("Heating"));
        assertFalse(state.isSystemActive("Ventilation"));
        assertFalse(state.isSystemActive("Lighting"));
        assertFalse(state.isSystemActive("Emergency Lighting"));
        assertFalse(state.isSystemActive("Low-Consumption Ventilation"));
    }
    
    @Test
    public void testStatePatternBehavior() {
        EnergySystemState[] states = {
            new ActiveState(),
            new EcoModeState(),
            new ShutdownState()
        };
        
        for (EnergySystemState state : states) {
            assertNotNull(state.getStateName());
            assertFalse(state.getStateName().isEmpty());
            
            assertNotNull(state.getStateDescription());
            assertFalse(state.getStateDescription().isEmpty());
            
            assertTrue(state.getEnergyConsumptionRate() >= 0);
            
            assertNotNull(state.isSystemActive("TestSystem"));
        }
    }
    
    @Test
    public void testEnergyConsumptionRates() {
        assertEquals(10, new ActiveState().getEnergyConsumptionRate());
        assertEquals(4, new EcoModeState().getEnergyConsumptionRate());
        assertEquals(0, new ShutdownState().getEnergyConsumptionRate());
    }
}
