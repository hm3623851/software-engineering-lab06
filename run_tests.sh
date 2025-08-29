#!/bin/bash

# Smart Building Energy Management System - Test Runner Script
# سیستم مدیریت انرژی هوشمند ساختمان - اسکریپت اجرای تست‌ها

echo "=== اجرای تست‌های سیستم مدیریت انرژی ==="
echo "=== Running Tests for Energy Management System ==="
echo ""

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "خطا: جاوا نصب نشده یا در PATH نیست"
    echo "Error: Java is not installed or not in PATH"
    echo "لطفا جاوا 11 یا بالاتر را نصب کنید"
    echo "Please install Java 11 or higher"
    exit 1
fi

# Check Java version
JAVA_VERSION=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 11 ]; then
    echo "خطا: جاوا 11 یا بالاتر مورد نیاز است. نسخه فعلی: $JAVA_VERSION"
    echo "Error: Java 11 or higher is required. Current version: $JAVA_VERSION"
    exit 1
fi

echo "نسخه جاوا: $(java -version 2>&1 | head -n 1)"
echo ""

# Check if JUnit is available
if [ ! -f "junit-4.13.2.jar" ] && [ ! -f "hamcrest-core-1.3.jar" ]; then
    echo "هشدار: فایل‌های JAR جی‌یونیت یافت نشد. در حال دانلود..."
    echo "Warning: JUnit JAR files not found. Downloading..."
    
    # Download JUnit and Hamcrest
    curl -O https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar
    curl -O https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
    
    if [ $? -ne 0 ]; then
        echo "خطا: دانلود فایل‌های JAR جی‌یونیت ناموفق بود"
        echo "Error: Failed to download JUnit JAR files"
        exit 1
    fi
fi

# Create bin directory if it doesn't exist
mkdir -p bin

echo "کامپایل فایل‌های جاوا..."
echo "Compiling Java files..."

# Compile all Java files including tests
javac -d bin -cp "src/main/java:src/test/java:junit-4.13.2.jar:hamcrest-core-1.3.jar" \
    src/main/java/com/energy/strategy/*.java \
    src/main/java/com/energy/state/*.java \
    src/main/java/com/energy/system/*.java \
    src/main/java/com/energy/main/*.java \
    src/test/java/com/energy/strategy/*.java \
    src/test/java/com/energy/state/*.java \
    src/test/java/com/energy/system/*.java

if [ $? -eq 0 ]; then
    echo "کامپایل موفقیت‌آمیز بود!"
    echo "Compilation successful!"
    echo ""
    
    echo "اجرای تست‌ها..."
    echo "Running tests..."
    echo ""
    
    # Run tests
    java -cp "bin:junit-4.13.2.jar:hamcrest-core-1.3.jar" org.junit.runner.JUnitCore \
        com.energy.strategy.PricingStrategyTest \
        com.energy.state.EnergySystemStateTest \
        com.energy.system.EnergyManagementSystemTest
    
    echo ""
    echo "تست‌ها تکمیل شد!"
    echo "Tests completed!"
else
    echo "کامپایل ناموفق بود!"
    echo "Compilation failed!"
    exit 1
fi
