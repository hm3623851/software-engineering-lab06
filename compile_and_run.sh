#!/bin/bash

# Smart Building Energy Management System - Compile and Run Script
# سیستم مدیریت انرژی هوشمند ساختمان - اسکریپت کامپایل و اجرا

echo "=== سیستم مدیریت انرژی هوشمند ساختمان ==="
echo "=== Smart Building Energy Management System ==="
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

# Create bin directory if it doesn't exist
mkdir -p bin

echo "کامپایل فایل‌های جاوا..."
echo "Compiling Java files..."

# Compile all Java files
javac -d bin -cp "src/main/java" \
    src/main/java/com/energy/strategy/*.java \
    src/main/java/com/energy/state/*.java \
    src/main/java/com/energy/system/*.java \
    src/main/java/com/energy/main/*.java

if [ $? -eq 0 ]; then
    echo "کامپایل موفقیت‌آمیز بود!"
    echo "Compilation successful!"
    echo ""
    
    echo "اجرای برنامه..."
    echo "Running the application..."
    echo ""
    
    # Run the application
    java -cp bin com.energy.main.EnergyManagementApp
else
    echo "کامپایل ناموفق بود!"
    echo "Compilation failed!"
    exit 1
fi
