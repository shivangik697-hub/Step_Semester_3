# Session 9 Assignment Solutions: Category C (OOP Fundamentals — Abstraction & Interfaces)

This directory contains complete Java implementations, unit test runner, and documentation for the Category C Assignment Problems (Session 9).

---

## 📋 Table of Contents & Solutions Overview

### Problem 1: Movie Ticket Counter
- **Core Concept:** Abstraction & Encapsulation via Abstract Base Class `Ticket`.
- **Derived Subclasses:** `RegularTicket` (150/ticket), `PremiumTicket` (250/ticket), `ReclinerTicket` (400/ticket). Encapsulates common convenience fee (`CONVENIENCE_FEE = 20`).
- **File:** `MovieTicketCounter.java`

### Problem 2: Parcel Shipping Desk
- **Core Concept:** Interface implementation (`Insurable`) for optional capabilities.
- **Derived Subclasses:** `StandardParcel` (non-insurable), `ExpressParcel` (insurable 2%), `FragileParcel` (insurable 2% + ₹50 handling fee).
- **File:** `ParcelShippingDesk.java`

### Problem 3: College Fee Counter
- **Core Concept:** Interface capability modeling (`BusUser`) without hardcoded type-name checks.
- **Derived Subclasses:** `DayScholarStudent` (implements `BusUser`), `HostellerStudent` (hostel fee ₹60000), `ScholarStudent` (half tuition + implements `BusUser`).
- **File:** `CollegeFeeCounter.java`

### Problem 4: City Cab Fare Meter
- **Core Concept:** Interface `NightServiceable` for optional feature support & error rejection.
- **Derived Subclasses:** `MiniCab` (non-night), `SedanCab` (implements `NightServiceable`), `SUVCab` (implements `NightServiceable`). Minimum fare rule of ₹100 encapsulated in base class `Cab`.
- **File:** `CityCabFareMeter.java`

### Problem 5: Home Appliance Energy Report
- **Core Concept:** Interface `SaverModeCapable` for feature validation and energy calculation.
- **Derived Subclasses:** `FridgeAppliance` (150W), `ACAppliance` (1500W, implements `SaverModeCapable`), `TVAppliance` (100W), `WasherAppliance` (500W, implements `SaverModeCapable`).
- **File:** `HomeApplianceEnergyReport.java`

---

## 🛠️ Verification & Expected Output

Running `java AssignmentProblem.Main` produces the following exact output matching all PDF specifications:

```text
=== Problem 1: Movie Ticket Counter ===
REGULAR: 510.00
PREMIUM: 540.00
RECLINER: 420.00
Total: 1470.00

=== Problem 2: Parcel Shipping Desk ===
STANDARD: Charge=70.00 Insurance=0.00 Total=70.00
EXPRESS: Charge=110.00 Insurance=20.00 Total=130.00
FRAGILE: Charge=130.00 Insurance=40.00 Total=170.00
Grand Total: 370.00

=== Problem 3: College Fee Counter ===
Asha: 52000.00
Ravi: 100000.00
Neha: 32000.00
Total Collected: 184000.00

=== Problem 4: City Cab Fare Meter ===
MINI: 100.00
SEDAN: 168.00
SUV: 360.00
MINI: night service not available
Total: 628.00

=== Problem 5: Home Appliance Energy Report ===
FRIDGE: Units=3.60 Cost=28.80
AC: Units=9.00 Cost=72.00
TV: Units=0.50 Cost=4.00
WASHER: Units=0.75 Cost=6.00
Total Cost: 110.80
```
