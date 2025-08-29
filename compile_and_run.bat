@echo off
REM Smart Building Energy Management System - Compile and Run Script
REM سیستم مدیریت انرژی هوشمند - اسکریپت کامپایل و اجرا

echo === Smart Building Energy Management System ===
echo === سیستم مدیریت انرژی هوشمند ===
echo.

REM Check if Java is installed
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH
    echo خطا: جاوا نصب نشده یا در PATH نیست
    echo Please install Java 11 or higher
    echo لطفا جاوا 11 یا بالاتر را نصب کنید
    pause
    exit /b 1
)

echo Java version:
java -version
echo.

REM Create bin directory if it doesn't exist
if not exist "bin" mkdir bin

echo Compiling Java files...
echo کامپایل فایل‌های جاوا...

REM Compile all Java files
javac -d bin -cp "src\main\java" ^
    src\main\java\com\energy\strategy\*.java ^
    src\main\java\com\energy\state\*.java ^
    src\main\java\com\energy\system\*.java ^
    src\main\java\com\energy\main\*.java

if errorlevel 1 (
    echo Compilation failed!
    echo کامپایل ناموفق بود!
    pause
    exit /b 1
)

echo Compilation successful!
echo کامپایل موفقیت‌آمیز بود!
echo.

echo Running the application...
echo اجرای برنامه...
echo.

REM Run the application
java -cp bin com.energy.main.EnergyManagementApp

pause
