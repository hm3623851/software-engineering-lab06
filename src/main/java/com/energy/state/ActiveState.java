package com.energy.state;

import com.energy.constants.EnergyConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ActiveState implements EnergySystemState {
    
    private static final Set<String> ACTIVE_SYSTEMS = new HashSet<>(Arrays.asList(
        EnergyConstants.HEATING_SYSTEM, 
        EnergyConstants.VENTILATION_SYSTEM, 
        EnergyConstants.LIGHTING_SYSTEM, 
        EnergyConstants.EMERGENCY_LIGHTING_SYSTEM, 
        EnergyConstants.LOW_CONSUMPTION_VENTILATION_SYSTEM
    ));
    
    @Override
    public int getEnergyConsumptionRate() {
        return EnergyConstants.ACTIVE_STATE_CONSUMPTION_RATE;
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
