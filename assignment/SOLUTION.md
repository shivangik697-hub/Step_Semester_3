# Session 8 Assignment Solutions: Category C (OOP Fundamentals — Polymorphism & Inheritance)

This directory contains complete Java implementations, unit test runner, and documentation for the Category C Assignment Problems (Session 8).

---

## 📋 Table of Contents & Solutions Overview

### Problem 1: The Canteen Billing Counter
- **Core Concept:** Polymorphism via Abstract Class `Customer`.
- **Derived Subclasses:** `StudentCustomer` (10% discount), `StaffCustomer` (5% discount), `GuestCustomer` (₹10 service charge).
- **File:** `CanteenBillingCounter.java`

### Problem 2: The Campus Parking Charge Calculator
- **Core Concept:** Polymorphism via Abstract Class `Vehicle`.
- **Derived Subclasses:** `BikeVehicle` (₹10/hr), `CarVehicle` (₹30 for 1st hr, ₹20/add. hr), `TruckVehicle` (₹50/hr, min ₹100).
- **File:** `CampusParkingChargeCalculator.java`

### Problem 3: The Hostel Electricity Bill
- **Core Concept:** Dynamic pricing rules and constructor state encapsulations for polymorphic types.
- **Derived Subclasses:** `SingleRoom` (₹8/unit), `SharedRoom` (₹6/unit divided by occupants), `ACRoom` (₹10/unit + ₹200 fixed fee).
- **File:** `HostelElectricityBill.java`

### Problem 4: The Festival Bonus Calculator
- **Core Concept:** Employee bonus calculation polymorphism.
- **Derived Subclasses:** `FullTimeEmployee` (10% of salary), `PartTimeEmployee` (5% of salary), `InternEmployee` (₹2,000 fixed).
- **File:** `FestivalBonusCalculator.java`

### Problem 5: The Streaming Plan Renewal Reminder
- **Core Concept:** Date calculation polymorphism utilizing `java.time.LocalDate`.
- **Derived Subclasses:** `BasicPlan` (+30 days), `StandardPlan` (+90 days), `PremiumPlan` (+365 days).
- **File:** `StreamingPlanRenewalReminder.java`

---

## 🛠️ Verification & Expected Execution Output

Running `java AssignmentProblem.Main` produces the following exact output matching all PDF specifications:

```text
=== Problem 1: The Canteen Billing Counter ===
STUDENT: 180.00
STAFF: 285.00
GUEST: 160.00
Total: 625.00

=== Problem 2: The Campus Parking Charge Calculator ===
BIKE: 30.00
CAR: 90.00
TRUCK: 100.00
CAR: 30.00
Total: 250.00

=== Problem 3: The Hostel Electricity Bill ===
SINGLE: 960.00
SHARED: 300.00
AC: 1200.00
Total: 2460.00

=== Problem 4: The Festival Bonus Calculator ===
Asha: 5000.00
Ravi: 1500.00
Neha: 2000.00
Total Bonus: 8500.00

=== Problem 5: The Streaming Plan Renewal Reminder ===
Asha: 2024-02-14
Ravi: 2024-05-01
Neha: 2025-03-10
Kiran: 2025-01-19
```
