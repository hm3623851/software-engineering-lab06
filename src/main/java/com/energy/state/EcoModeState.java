package com.energy.state;

import com.energy.constants.EnergyConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EcoModeState implements EnergySystemState {
    
    private static final Set<String> ACTIVE_SYSTEMS = new HashSet<>(Arrays.asList(
        EnergyConstants.EMERGENCY_LIGHTING_SYSTEM, 
        EnergyConstants.LOW_CONSUMPTION_VENTILATION_SYSTEM
    ));
    
    @Override
    public int getEnergyConsumptionRate() {
        return EnergyConstants.ECO_MODE_CONSUMPTION_RATE;
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
