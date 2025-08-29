package com.energy.state;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ActiveState implements EnergySystemState {
    
    private static final int ENERGY_CONSUMPTION_RATE = 10;
    private static final Set<String> ACTIVE_SYSTEMS = new HashSet<>(Arrays.asList(
        "Heating", "Ventilation", "Lighting", "Emergency Lighting", "Low-Consumption Ventilation"
    ));
    
    @Override
    public int getEnergyConsumptionRate() {
        return ENERGY_CONSUMPTION_RATE;
    }
    
    @Override
    public String getStateName() {
        return "فعال";
    }
    
    @Override
    public String getStateDescription() {
        return "همه سیستم‌ها با ظرفیت کامل در حال کار هستند";
    }
    
    @Override
    public boolean isSystemActive(String systemName) {
        return ACTIVE_SYSTEMS.contains(systemName);
    }
}
