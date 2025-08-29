package com.energy.state;

import java.util.Collections;
import java.util.Set;

public class ShutdownState implements EnergySystemState {
    
    private static final int ENERGY_CONSUMPTION_RATE = 0;
    private static final Set<String> ACTIVE_SYSTEMS = Collections.emptySet();
    
    @Override
    public int getEnergyConsumptionRate() {
        return ENERGY_CONSUMPTION_RATE;
    }
    
    @Override
    public String getStateName() {
        return "خاموش";
    }
    
    @Override
    public String getStateDescription() {
        return "همه سیستم‌ها خاموش هستند";
    }
    
    @Override
    public boolean isSystemActive(String systemName) {
        return ACTIVE_SYSTEMS.contains(systemName);
    }
}
