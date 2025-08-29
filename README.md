# سیستم مدیریت پویای مصرف انرژی هوشمند در یک ساختمان اداری

## Smart Building Energy Management System

این پروژه یک سیستم مدیریت انرژی هوشمند برای ساختمان‌های اداری است که از دو الگوی طراحی **Strategy** و **State** استفاده می‌کند.

## فهرست مطالب

- [معرفی پروژه](#معرفی-پروژه)
- [الگوهای طراحی استفاده شده](#الگوهای-طراحی-استفاده-شده)
- [ساختار پروژه](#ساختار-پروژه)
- [نحوه اجرا](#نحوه-اجرا)
- [تست‌ها](#تست‌ها)
- [توضیحات پیاده‌سازی](#توضیحات-پیاده‌سازی)

## معرفی پروژه

این سیستم قابلیت‌های زیر را فراهم می‌کند:

- **مدیریت وضعیت سیستم انرژی**: سه حالت مختلف (فعال، اقتصادی، خاموش)
- **استراتژی‌های مختلف قیمت‌گذاری**: تعرفه معمولی، اوج مصرف، و حالت سبز
- **شبیه‌سازی مصرف انرژی**: محاسبه هزینه بر اساس استراتژی فعلی
- **رابط کاربری تعاملی**: منوهای جداگانه برای کاربران و مدیران

## الگوهای طراحی استفاده شده

### 1. الگوی Strategy (استراتژی)

**هدف**: امکان تغییر روش محاسبه هزینه انرژی در زمان اجرا

**پیاده‌سازی**:
- `PricingStrategy` - رابط اصلی استراتژی
- `StandardPricingStrategy` - تعرفه معمولی (500 تومان)
- `PeakHoursPricingStrategy` - تعرفه اوج مصرف (1000 تومان)
- `GreenModePricingStrategy` - تعرفه سبز (300 تومان)

**مزایا**:
- امکان تغییر استراتژی قیمت‌گذاری بدون تغییر کد اصلی
- انعطاف‌پذیری در زمان اجرا
- قابلیت اضافه کردن استراتژی‌های جدید

### 2. الگوی State (وضعیت)

**هدف**: مدیریت وضعیت‌های مختلف سیستم انرژی

**پیاده‌سازی**:
- `EnergySystemState` - رابط اصلی وضعیت
- `ActiveState` - حالت فعال (همه سیستم‌ها روشن)
- `EcoModeState` - حالت اقتصادی (فقط سیستم‌های حیاتی)
- `ShutdownState` - حالت خاموش (همه سیستم‌ها خاموش)

**مزایا**:
- مدیریت رفتار سیستم بر اساس وضعیت فعلی
- امکان تغییر وضعیت بدون تغییر منطق اصلی
- جداسازی منطق هر وضعیت

## ساختار پروژه

```
src/
├── main/java/com/energy/
│   ├── strategy/           # الگوی Strategy
│   │   ├── PricingStrategy.java
│   │   ├── StandardPricingStrategy.java
│   │   ├── PeakHoursPricingStrategy.java
│   │   └── GreenModePricingStrategy.java
│   ├── state/             # الگوی State
│   │   ├── EnergySystemState.java
│   │   ├── ActiveState.java
│   │   ├── EcoModeState.java
│   │   └── ShutdownState.java
│   ├── system/            # کلاس اصلی سیستم
│   │   └── EnergyManagementSystem.java
│   └── main/              # کلاس اصلی برنامه
│       └── EnergyManagementApp.java
└── test/java/com/energy/  # تست‌ها (TDD)
    ├── strategy/
    ├── state/
    └── system/
```

## نحوه اجرا

### پیش‌نیازها
- Java 11 یا بالاتر
- Maven 3.6 یا بالاتر

### کامپایل و اجرا
```bash
# کامپایل پروژه
mvn compile

# اجرای تست‌ها
mvn test

# اجرای برنامه
mvn exec:java -Dexec.mainClass="com.energy.main.EnergyManagementApp"
```

### اجرای مستقیم
```bash
# کامپایل
javac -cp "src/main/java" src/main/java/com/energy/main/EnergyManagementApp.java

# اجرا
java -cp "src/main/java" com.energy.main.EnergyManagementApp
```

## تست‌ها

این پروژه از رویکرد **TDD (Test-Driven Development)** استفاده می‌کند:

### تست‌های Strategy Pattern
- `PricingStrategyTest`: تست تمام استراتژی‌های قیمت‌گذاری
- بررسی محاسبه هزینه برای مقادیر مختلف انرژی
- تست تغییر استراتژی در زمان اجرا

### تست‌های State Pattern
- `EnergySystemStateTest`: تست تمام وضعیت‌های سیستم
- بررسی نرخ مصرف انرژی در هر وضعیت
- تست تغییر وضعیت سیستم

### تست‌های یکپارچه
- `EnergyManagementSystemTest`: تست یکپارچگی الگوها
- بررسی عملکرد همزمان Strategy و State
- تست شبیه‌سازی مصرف انرژی

## توضیحات پیاده‌سازی

### کلاس اصلی سیستم (`EnergyManagementSystem`)

این کلاس هر دو الگوی Strategy و State را یکپارچه می‌کند:

```java
public class EnergyManagementSystem {
    private PricingStrategy pricingStrategy;    // Strategy Pattern
    private EnergySystemState currentState;    // State Pattern
    
    // تغییر استراتژی قیمت‌گذاری
    public void changePricingStrategy(PricingStrategy newStrategy)
    
    // تغییر وضعیت سیستم
    public void changeSystemState(EnergySystemState newState)
    
    // محاسبه هزینه با استراتژی فعلی
    public double calculateTotalCost()
}
```

### ویژگی‌های کلیدی

1. **انعطاف‌پذیری**: امکان تغییر استراتژی و وضعیت در زمان اجرا
2. **جداسازی مسئولیت**: هر کلاس مسئولیت مشخصی دارد
3. **قابلیت گسترش**: امکان اضافه کردن استراتژی‌ها و وضعیت‌های جدید
4. **تست‌پذیری**: کد به گونه‌ای نوشته شده که به راحتی قابل تست باشد

### منوی تعاملی

برنامه دارای دو منوی اصلی است:

- **منوی کاربر**: مشاهده وضعیت، محاسبه هزینه، شبیه‌سازی
- **منوی مدیر**: تغییر استراتژی، تغییر وضعیت، شبیه‌سازی مصرف

## نتیجه‌گیری

این پروژه نشان‌دهنده کاربرد عملی الگوهای طراحی Strategy و State در یک سیستم مدیریت انرژی واقعی است. استفاده از این الگوها باعث:

- **قابلیت نگهداری بهتر** کد
- **انعطاف‌پذیری بیشتر** در زمان اجرا
- **قابلیت تست بهتر** با رویکرد TDD
- **ساختار منظم‌تر** و قابل فهم‌تر

پروژه به زبان Java پیاده‌سازی شده و از Maven برای مدیریت وابستگی‌ها استفاده می‌کند.
