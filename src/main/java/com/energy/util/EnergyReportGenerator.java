package com.energy.util;

import com.energy.strategy.PricingStrategy;
import com.energy.state.EnergySystemState;

public class EnergyReportGenerator {
    
    public static String generateDetailedReport(EnergySystemState state, PricingStrategy strategy, int totalConsumed) {
        StringBuilder report = new StringBuilder();
        report.append("=== گزارش تفصیلی سیستم انرژی ===\n");
        report.append("وضعیت فعلی: ").append(state.getStateName()).append("\n");
        report.append("توضیح وضعیت: ").append(state.getStateDescription()).append("\n");
        report.append("نرخ مصرف: ").append(state.getEnergyConsumptionRate()).append(" واحد/ساعت\n");
        report.append("استراتژی قیمت: ").append(strategy.getStrategyName()).append("\n");
        report.append("قیمت هر واحد: ").append(strategy.getPricePerUnit()).append(" تومان\n");
        report.append("کل مصرف: ").append(totalConsumed).append(" واحد\n");
        report.append("هزینه کل: ").append(strategy.calculateCost(totalConsumed)).append(" تومان\n");
        report.append("================================");
        return report.toString();
    }
    
    public static String generateSummaryReport(EnergySystemState state, PricingStrategy strategy, int totalConsumed) {
        return String.format("خلاصه: %s | %s | مصرف: %d واحد | هزینه: %.0f تومان", 
                           state.getStateName(), 
                           strategy.getStrategyName(), 
                           totalConsumed, 
                           strategy.calculateCost(totalConsumed));
    }
    
    public static String generateEfficiencyReport(EnergySystemState state, PricingStrategy strategy) {
        double efficiency = calculateEfficiency(state, strategy);
        return String.format("کارایی سیستم: %.1f%% (وضعیت: %s, استراتژی: %s)", 
                           efficiency, state.getStateName(), strategy.getStrategyName());
    }
    
    private static double calculateEfficiency(EnergySystemState state, PricingStrategy strategy) {
        double baseEfficiency = 100.0;
        if (state.getEnergyConsumptionRate() == 0) {
            baseEfficiency = 100.0;
        } else if (state.getEnergyConsumptionRate() <= 4) {
            baseEfficiency = 90.0;
        } else if (state.getEnergyConsumptionRate() <= 10) {
            baseEfficiency = 70.0;
        } else {
            baseEfficiency = 50.0;
        }
        
        if ("GREEN".equals(strategy.getPricingCategory())) {
            baseEfficiency += 10.0;
        }
        
        return Math.min(baseEfficiency, 100.0);
    }
}
