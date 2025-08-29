package com.energy.constants;

public final class EnergyConstants {
    
    private EnergyConstants() {}
    
    // Pricing constants
    public static final double STANDARD_PRICE_PER_UNIT = 500.0;
    public static final double PEAK_HOURS_PRICE_PER_UNIT = 1000.0;
    public static final double GREEN_MODE_PRICE_PER_UNIT = 300.0;
    
    // Energy consumption rates
    public static final int ACTIVE_STATE_CONSUMPTION_RATE = 10;
    public static final int ECO_MODE_CONSUMPTION_RATE = 4;
    public static final int SHUTDOWN_STATE_CONSUMPTION_RATE = 0;
    
    // Time constants
    public static final int HOURS_PER_DAY = 24;
    public static final int HOURS_PER_WEEK = 168;
    public static final int HOURS_PER_MONTH = 720;
    
    // Efficiency thresholds
    public static final double HIGH_EFFICIENCY_THRESHOLD = 4.0;
    public static final double MEDIUM_EFFICIENCY_THRESHOLD = 10.0;
    public static final double MAX_EFFICIENCY_PERCENTAGE = 100.0;
    public static final double ECO_BONUS_PERCENTAGE = 10.0;
    
    // Discount rates
    public static final double NO_DISCOUNT = 0.0;
    public static final double STANDARD_DISCOUNT = 0.1;
    public static final double PREMIUM_DISCOUNT = 0.2;
    
    // System names
    public static final String HEATING_SYSTEM = "Heating";
    public static final String VENTILATION_SYSTEM = "Ventilation";
    public static final String LIGHTING_SYSTEM = "Lighting";
    public static final String EMERGENCY_LIGHTING_SYSTEM = "Emergency Lighting";
    public static final String LOW_CONSUMPTION_VENTILATION_SYSTEM = "Low-Consumption Ventilation";
    
    // Pricing categories
    public static final String STANDARD_CATEGORY = "STANDARD";
    public static final String PEAK_CATEGORY = "PEAK";
    public static final String GREEN_CATEGORY = "GREEN";
    
    // Simulation types
    public static final String STANDARD_SIMULATION = "STANDARD";
    public static final String DISCOUNTED_SIMULATION = "DISCOUNTED";
    public static final String ECO_SIMULATION = "ECO";
}
