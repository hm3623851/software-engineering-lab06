package com.energy.model;

public class EnergySimulationParams {
    
    private final int hours;
    private final double discountRate;
    private final boolean includeEfficiency;
    private final String simulationType;
    
    public EnergySimulationParams(int hours, double discountRate, boolean includeEfficiency, String simulationType) {
        this.hours = hours;
        this.discountRate = discountRate;
        this.includeEfficiency = includeEfficiency;
        this.simulationType = simulationType;
    }
    
    public EnergySimulationParams(int hours) {
        this(hours, 0.0, false, "STANDARD");
    }
    
    public EnergySimulationParams(int hours, double discountRate) {
        this(hours, discountRate, false, "DISCOUNTED");
    }
    
    public int getHours() {
        return hours;
    }
    
    public double getDiscountRate() {
        return discountRate;
    }
    
    public boolean isIncludeEfficiency() {
        return includeEfficiency;
    }
    
    public String getSimulationType() {
        return simulationType;
    }
    
    public boolean hasDiscount() {
        return discountRate > 0.0;
    }
    
    public boolean isEcoSimulation() {
        return "ECO".equals(simulationType);
    }
}
