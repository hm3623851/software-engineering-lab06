package com.energy.state;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EcoModeState implements EnergySystemState {
    
    private static final int ENERGY_CONSUMPTION_RATE = 4;
    private static final Set<String> ACTIVE_SYSTEMS = new HashSet<>(Arrays.asList(
        "Emergency Lighting", "Low-Consumption Ventilation"
    ));
    
    @Override
    public int getEnergyConsumptionRate() {
        return ENERGY_CONSUMPTION_RATE;
    }
    
    @Override
    public String getStateName() {
        return "حالت اقتصادی";
    }
    
    @Override
    public String getStateDescription() {
        return "فقط سیستم‌های حیاتی (روشنایی اضطراری و تهویه کم‌مصرف) در حال کار هستند";
    }
    
    @Override
    public boolean isSystemActive(String systemName) {
        return ACTIVE_SYSTEMS.contains(systemName);
    }
}
