# Session 9 Practice Problems: Category C (OOP Fundamentals — Abstraction & Interfaces)

This directory contains complete Java implementations, unit test runner, and documentation for the Category C Practice Problems (Session 9).

---

## 📋 Part A — Coding Problems Overview

### Problem 1: Garden Plot Area Report
- **Core Concept:** Abstraction via Abstract Class `Plot`.
- **Derived Subclasses:** `CirclePlot` ($\pi r^2$), `RectanglePlot` ($l \times w$), `TrianglePlot` ($\frac{1}{2} b h$).
- **File:** `GardenPlotAreaReport.java`

### Problem 2: Weekly Staff Pay
- **Core Concept:** Abstract Base Class `StaffMember` enforcing pay logic in subclasses.
- **Derived Subclasses:** `FullTimeStaff` (fixed salary), `HourlyStaff` (overtime 1.5x after 40 hrs), `InternStaff` (fixed stipend).
- **File:** `WeeklyStaffPay.java`

### Problem 3: Library Late Fine Counter
- **Core Concept:** Abstract Class `LibraryItem` for item-specific fine rules.
- **Derived Subclasses:** `BookItem` (₹2/day), `DvdItem` (₹5/day max ₹50), `MagazineItem` (₹1/day).
- **File:** `LibraryLateFineCounter.java`

### Problem 4: Electricity Connection Billing
- **Core Concept:** Abstract Class `Connection` modeling tiered billing logic.
- **Derived Subclasses:** `HomeConnection` (tiered 5 & 7 per unit), `ShopConnection` (8 per unit + 100 fixed), `FactoryConnection` (6 per unit, min 1000).
- **File:** `ElectricityConnectionBilling.java`

### Problem 5: Travel Booking with a Common Fee
- **Core Concept:** Base Class encapsulation of shared booking fee (`BOOKING_FEE = 50`).
- **Derived Subclasses:** `BusBooking` (₹2/km), `TrainBooking` (₹1.5/km), `FlightBooking` (₹2500 + ₹4/km).
- **File:** `TravelBookingCommonFee.java`

---

## 🛠️ Verification & Expected Output

Running `java PracticeProblem.Main` produces the following exact output matching all PDF specifications:

```text
=== Problem 1: Garden Plot Area Report ===
Asha (CIRCLE): 78.54
Ravi (RECTANGLE): 24.00
Neha (TRIANGLE): 15.00
Total Area: 117.54

=== Problem 2: Weekly Staff Pay ===
Asha: 12000.00
Ravi: 9500.00
Neha: 5000.00
Total Payroll: 26500.00

=== Problem 3: Library Late Fine Counter ===
Algebra: 8.00
Inception: 50.00
Sports: 3.00
Total Fines: 61.00

=== Problem 4: Electricity Connection Billing ===
HOME: 850.00
SHOP: 820.00
FACTORY: 1000.00
Total: 2670.00

=== Problem 5: Travel Booking with a Common Fee ===
BUS: 450.00
TRAIN: 500.00
FLIGHT: 4550.00
```

---

## ❓ Part B — Quiz Answers & Explanations

- **Q1:** **C. Hiding how an object performs its operations and showing only what it does**
  - *Explanation:* Abstraction exposes high-level behavior while hiding implementation details.
- **Q2:** **C. It cannot be instantiated directly**
  - *Explanation:* Abstract classes cannot be instantiated using `new`.
- **Q3:** **B. The class must be declared abstract, or the code will not compile**
  - *Explanation:* Concrete subclasses must implement all inherited abstract methods.
- **Q4:** **C. private**
  - *Explanation:* Private methods cannot be overridden by subclasses.
- **Q5:** **C. public, static, and final**
  - *Explanation:* Interface fields are implicit constants (`public static final`).
- **Q6:** **C. Any number of interfaces**
  - *Explanation:* Java supports multiple interface implementation.
- **Q7:** **D. public**
  - *Explanation:* Implemented interface methods must be public.
- **Q8:** **C. Interfaces carry no instance state, avoiding the 'diamond problem' ambiguity with conflicting data inheritance**
  - *Explanation:* Interfaces lack instance fields, avoiding state diamond conflicts.
- **Q9:** **D. A compile-time error occurs until the class overrides the method**
  - *Explanation:* Duplicate default method signatures require explicit overriding in the implementing class.
- **Q10:** **B. Abstract classes can have constructors that run when a subclass object is created**
  - *Explanation:* Abstract class constructors run via `super()` constructor chaining.

---

## 💡 Part C — Concept Questions Answers

### Question 1: Abstraction in Own Words
Abstraction focuses on exposing essential functionalities while obscuring internal implementation complexities.
*Real-Life Example:* A Smart TV Remote. The user interacts with high-level buttons (Power, Volume, Channel), while infrared signal encoding, circuit board logic, and display panel firmware remain hidden.

### Question 2: Abstraction vs. Encapsulation
- **Abstraction:** Design-level concept ("WHAT an object does rather than HOW").
- **Encapsulation:** Implementation-level concept ("wrapping data and code together, restricting access via private fields").
*Together:* Encapsulation protects private fields, while abstraction exposes public abstract/concrete methods that safely manipulate that state.

### Question 3: Constructors in Abstract Classes
An abstract class cannot be instantiated directly, but it defines constructors to initialize inherited fields shared by all subclasses. When a concrete subclass object is instantiated, the abstract class constructor executes via constructor chaining (`super()`).

### Question 4: Restrictions on Abstract Methods (`private`, `static`, `final`)
- `private`: Cannot be overridden because private members are invisible to subclasses.
- `static`: Belongs to the class and resolves at compile-time without dynamic polymorphic dispatch.
- `final`: Explicitly prevents overriding, directly contradicting the requirement of abstract methods.

### Question 5: The Diamond Problem in Inheritance
The 'diamond problem' occurs in multiple class inheritance when a subclass inherits conflicting fields/methods from two parents sharing a common ancestor. Java avoids state diamond conflicts by restricting classes to single inheritance. Because interfaces carry no instance fields, implementing multiple interfaces prevents state ambiguity. For conflicting default methods, Java triggers a compile-time error requiring explicit resolution.
