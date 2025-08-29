# گزارش پروژه سیستم مدیریت انرژی هوشمند

این گزارش شامل 7 مورد بازآرایی مختلف است که بر روی پروژه سیستم مدیریت انرژی هوشمند انجام شده است.

### 1. اعمال الگوی Facade

**توضیح**: یک کلاس Facade ایجاد شد که تعامل پیچیده با زیرسیستم‌های مختلف را ساده‌سازی می‌کند. این کلاس عملیات‌های متداول مانند تغییر به حالت اقتصادی، شبیه‌سازی روزانه و دریافت خلاصه سیستم را در یک رابط ساده ارائه می‌دهد.

**فایل**: `src/main/java/com/energy/facade/EnergyManagementFacade.java`

### 2. استفاده از Polymorphism به جای شرط (Strategy/State)

**توضیح**: با اضافه کردن متد `getPricingCategory()` به رابط `PricingStrategy` و پیاده‌سازی آن در کلاس‌های مختلف، منطق شرطی با استفاده از polymorphism جایگزین شد. کلاس `PricingCalculator` نیز ایجاد شد که از این polymorphism برای محاسبات مختلف استفاده می‌کند.

**فایل‌ها**: `PricingStrategy.java`, `StandardPricingStrategy.java`, `PeakHoursPricingStrategy.java`, `GreenModePricingStrategy.java`, `PricingCalculator.java`

### 3. Separate Query From Modifier

**توضیح**: متدهای `getStatusReport()` و `resetEnergyConsumption()` به کلاس `EnergyManagementSystem` اضافه شدند تا عملیات پرس و جو از عملیات تغییر جدا شوند. این باعث بهبود خوانایی کد و کاهش عوارض جانبی می‌شود.

**فایل**: `src/main/java/com/energy/system/EnergyManagementSystem.java`

### 4. Self Encapsulated Field

**توضیح**: تمام فیلدهای خصوصی کلاس `EnergyManagementSystem` با استفاده از متدهای getter و setter خصوصی کپسوله شدند. این کار امکان کنترل بهتر بر روی دسترسی به فیلدها و امکان اضافه کردن منطق اضافی در آینده را فراهم می‌کند.

**فایل**: `src/main/java/com/energy/system/EnergyManagementSystem.java`

### 5. Extract Method

**توضیح**: کلاس `EnergyReportGenerator` ایجاد شد تا منطق تولید گزارش‌های مختلف از کلاس اصلی سیستم استخراج شود. این کلاس شامل متدهای `generateDetailedReport`، `generateSummaryReport` و `generateEfficiencyReport` است که هر کدام مسئولیت خاصی دارند.

**فایل**: `src/main/java/com/energy/util/EnergyReportGenerator.java`

### 6. Introduce Parameter Object

**توضیح**: کلاس `EnergySimulationParams` ایجاد شد تا پارامترهای متعدد شبیه‌سازی انرژی (ساعات، نرخ تخفیف، شامل کارایی، نوع شبیه‌سازی) را در یک شیء واحد کپسوله کند. این کار باعث بهبود خوانایی و نگهداری کد می‌شود.

**فایل**: `src/main/java/com/energy/model/EnergySimulationParams.java`

### 7. Replace Magic Numbers with Named Constants

**توضیح**: کلاس `EnergyConstants` ایجاد شد که تمام اعداد جادویی مانند قیمت‌ها، نرخ‌های مصرف، آستانه‌های کارایی و نام‌های سیستم را با ثابت‌های معنادار جایگزین می‌کند. این کار باعث بهبود خوانایی و کاهش خطاهای تایپی می‌شود.

**فایل**: `src/main/java/com/energy/constants/EnergyConstants.java`

## مزایای بازآرایی‌های انجام شده

- **بهبود خوانایی کد**: کد تمیزتر و قابل فهم‌تر شده است
- **کاهش تکرار**: منطق مشترک در کلاس‌های جداگانه قرار گرفته است
- **افزایش انعطاف‌پذیری**: تغییرات آینده راحت‌تر اعمال می‌شوند
- **بهبود قابلیت نگهداری**: ساختار کد منظم‌تر و قابل نگهداری‌تر شده است
- **کاهش وابستگی**: کلاس‌ها کمتر به یکدیگر وابسته هستند

## پلاگین Maven Formatter

پلاگین `maven-java-formatter-plugin` به فایل `pom.xml` اضافه شده است که کد را به صورت خودکار فرمت می‌کند و از استاندارد Google Java Style استفاده می‌کند.

## نتیجه‌گیری

تمام 7 مورد بازآرایی با موفقیت انجام شده و کد پروژه بهبود قابل توجهی یافته است. ساختار پروژه حالا منظم‌تر، قابل نگهداری‌تر و قابل گسترش‌تر است.

