package com.energy.state;

public interface EnergySystemState {
    
    int getEnergyConsumptionRate();
    
    String getStateName();
    
    String getStateDescription();
    
    boolean isSystemActive(String systemName);
}
