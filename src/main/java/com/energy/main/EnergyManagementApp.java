package com.energy.main;

import com.energy.system.EnergyManagementSystem;
import com.energy.strategy.*;
import com.energy.state.*;
import java.util.Scanner;

public class EnergyManagementApp {
    
    private static EnergyManagementSystem energySystem;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        System.out.println("=== سیستم مدیریت انرژی هوشمند ساختمان ===");
        System.out.println("به سیستم مدیریت انرژی خوش آمدید!");
        
        energySystem = new EnergyManagementSystem();
        scanner = new Scanner(System.in);
        
        energySystem.displayStatus();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("انتخاب خود را وارد کنید: ");
            
            switch (choice) {
                case 1:
                    userMenu();
                    break;
                case 2:
                    managerMenu();
                    break;
                case 3:
                    running = false;
                    System.out.println("از استفاده از سیستم مدیریت انرژی متشکریم!");
                    break;
                default:
                    System.out.println("انتخاب نامعتبر. لطفاً دوباره تلاش کنید.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n=== منوی اصلی ===");
        System.out.println("1. منوی کاربر");
        System.out.println("2. منوی مدیر");
        System.out.println("3. خروج");
    }
    
    private static void userMenu() {
        boolean inUserMenu = true;
        while (inUserMenu) {
            System.out.println("\n=== منوی کاربر ===");
            System.out.println("1. مشاهده وضعیت فعلی سیستم");
            System.out.println("2. مشاهده هزینه کل انرژی");
            System.out.println("3. شبیه‌سازی هزینه مصرف انرژی");
            System.out.println("4. بازگشت به منوی اصلی");
            
            int choice = getIntInput("انتخاب خود را وارد کنید: ");
            
            switch (choice) {
                case 1:
                    energySystem.displayStatus();
                    break;
                case 2:
                    System.out.println("هزینه کل انرژی: " + energySystem.calculateTotalCost() + " تومان");
                    break;
                case 3:
                    simulateEnergyCost();
                    break;
                case 4:
                    inUserMenu = false;
                    break;
                default:
                    System.out.println("انتخاب نامعتبر. لطفاً دوباره تلاش کنید.");
            }
        }
    }
    
    private static void managerMenu() {
        boolean inManagerMenu = true;
        while (inManagerMenu) {
            System.out.println("\n=== منوی مدیر ===");
            System.out.println("1. تغییر استراتژی قیمت‌گذاری");
            System.out.println("2. تغییر وضعیت سیستم");
            System.out.println("3. شبیه‌سازی مصرف انرژی");
            System.out.println("4. مشاهده وضعیت فعلی");
            System.out.println("5. بازگشت به منوی اصلی");
            
            int choice = getIntInput("انتخاب خود را وارد کنید: ");
            
            switch (choice) {
                case 1:
                    changePricingStrategy();
                    break;
                case 2:
                    changeSystemState();
                    break;
                case 3:
                    simulateEnergyConsumption();
                    break;
                case 4:
                    energySystem.displayStatus();
                    break;
                case 5:
                    inManagerMenu = false;
                    break;
                default:
                    System.out.println("انتخاب نامعتبر. لطفاً دوباره تلاش کنید.");
            }
        }
    }
    
    private static void changePricingStrategy() {
        System.out.println("\n=== تغییر استراتژی قیمت‌گذاری ===");
        System.out.println("1. استاندارد (500 تومان برای هر واحد)");
        System.out.println("2. ساعات اوج مصرف (1000 تومان برای هر واحد)");
        System.out.println("3. حالت سبز (300 تومان برای هر واحد)");
        
        int choice = getIntInput("استراتژی قیمت‌گذاری را انتخاب کنید: ");
        
        PricingStrategy newStrategy = null;
        switch (choice) {
            case 1:
                newStrategy = new StandardPricingStrategy();
                break;
            case 2:
                newStrategy = new PeakHoursPricingStrategy();
                break;
            case 3:
                newStrategy = new GreenModePricingStrategy();
                break;
            default:
                System.out.println("انتخاب نامعتبر. استراتژی تغییر نکرد.");
                return;
        }
        
        energySystem.changePricingStrategy(newStrategy);
    }
    
    private static void changeSystemState() {
        System.out.println("\n=== تغییر وضعیت سیستم ===");
        System.out.println("1. فعال (همه سیستم‌ها روشن)");
        System.out.println("2. حالت اقتصادی (فقط سیستم‌های حیاتی)");
        System.out.println("3. خاموش (همه سیستم‌ها خاموش)");
        
        int choice = getIntInput("وضعیت سیستم را انتخاب کنید: ");
        
        EnergySystemState newState = null;
        switch (choice) {
            case 1:
                newState = new ActiveState();
                break;
            case 2:
                newState = new EcoModeState();
                break;
            case 3:
                newState = new ShutdownState();
                break;
            default:
                System.out.println("انتخاب نامعتبر. وضعیت تغییر نکرد.");
                return;
        }
        
        energySystem.changeSystemState(newState);
    }
    
    private static void simulateEnergyConsumption() {
        System.out.println("\n=== شبیه‌سازی مصرف انرژی ===");
        int hours = getIntInput("تعداد ساعات شبیه‌سازی را وارد کنید: ");
        
        if (hours > 0) {
            energySystem.simulateEnergyConsumption(hours);
        } else {
            System.out.println("تعداد ساعات نامعتبر است.");
        }
    }
    
    private static void simulateEnergyCost() {
        System.out.println("\n=== شبیه‌سازی هزینه انرژی ===");
        int energyUnits = getIntInput("تعداد واحدهای انرژی برای محاسبه هزینه را وارد کنید: ");
        
        if (energyUnits > 0) {
            double cost = energySystem.simulateCost(energyUnits);
            System.out.println("هزینه برای " + energyUnits + " واحد انرژی: " + cost + " تومان");
        } else {
            System.out.println("تعداد واحدهای انرژی نامعتبر است.");
        }
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("لطفاً یک عدد معتبر وارد کنید.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }
}
