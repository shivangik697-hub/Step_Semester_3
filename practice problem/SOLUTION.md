# Session 8 Solutions: OOP Fundamentals — Polymorphism & Inheritance

This directory contains complete Java implementations, unit tests, quiz answers, and detailed concept explanations for Session 8.

---

## Part 1: Coding Questions (Java Solutions)

### Problem 1: Payment System Fee Calculation
- **Concept:** Polymorphism via Abstract Base Class `Payment`.
- **Derived Classes:** `CardPayment`, `WalletPayment`, `BankTransferPayment`.
- **File:** `PaymentFeeCalculator.java`

### Problem 2: Library Item Due Date Calculator
- **Concept:** Polymorphism for calculation rules using Java `LocalDate`.
- **Derived Classes:** `BookItem` (14 days), `DvdItem` (7 days), `MagazineItem` (3 days).
- **File:** `LibraryDueDateCalculator.java`

### Problem 3: Delivery Fee Calculator
- **Concept:** Inheritance and parameter customization in derived classes.
- **Derived Classes:** `StandardDelivery`, `ExpressDelivery`, `InternationalDelivery`.
- **File:** `DeliveryFeeCalculator.java`

### Problem 4: Examination Question Grader
- **Concept:** Dynamic score evaluation across multiple question types.
- **Derived Classes:** `MultipleChoiceQuestion`, `TrueFalseQuestion`, `EssayQuestion`.
- **File:** `ExamQuestionGrader.java`

### Problem 5: Public Transport Fare Calculator
- **Concept:** Base & capped pricing structures via Polymorphic methods.
- **Derived Classes:** `BusJourney`, `TrainJourney`, `MetroJourney`.
- **File:** `TransportFareCalculator.java`

---

## Part 2: Quiz Questions Solutions

### Question 1
- **Answer:** **C Polymorphism**
- **Explanation:** Repeated `if-else if` checks for concrete types can be eliminated by defining a common method `render()` on the base class `Document` and overriding it in derived classes (`PDFDocument`, `WordDocument`), leveraging dynamic dispatch.

### Question 2
- **Answer:** **A, B, C**
- **Explanation:**
  - A: `Car` IS-A `Vehicle` (Valid inheritance).
  - B: `Rectangle` IS-A `Shape` (Valid inheritance).
  - C: `DatabaseConnection` IS-A `NetworkResource` (Valid inheritance).
  - D: `HelperUtility` HAS-A `Calculator` (Composition, not inheritance).

### Question 3
- **Answer:** **C Runtime method dispatch**
- **Explanation:** In Java/OOP, late binding / runtime method dispatch determines the actual method implementation to invoke based on the runtime type of the object, not the reference type.

### Question 4
- **Answer:** **C Inheritance-based polymorphism**
- **Explanation:** Calling `calculateArea()` on a collection of `Shape` references holding derived `Circle` and `Rectangle` objects showcases inheritance-based polymorphism.

### Question 5
- **Answer:** **A, C, D**
- **Explanation:**
  - A: `Book` extends/overrides `getLoanPeriod()`.
  - C: `LibraryItem` defines common interface contracts.
  - D: A `DVD` instance can be stored and referenced as a `LibraryItem`.

### Question 6
- **Answer:** **A, C**
- **Explanation:**
  - A: Calling `makeSound()` on an `Animal` reference pointing to a `Dog` executes `Dog`'s implementation.
  - C: `makeSound()` in `Dog` overrides `Animal`'s default method.

### Question 7
- **Answer:** **C It allows adding `WalletPayment` without modifying the existing `PaymentProcessor`'s iteration logic.**
- **Explanation:** Following the Open-Closed Principle (OCP), new derived payment classes can be introduced without altering client/processor code that operates on `Payment` references.

### Question 8
- **Answer:** **A It leads to tighter coupling and incorrect 'is-a' relationships, making the design rigid.**
- **Explanation:** Using inheritance purely for helper code reuse creates artificial, fragile class hierarchies. Composition over inheritance is preferred in such cases.

### Question 9
- **Answer:** **A, C**
- **Explanation:**
  - A: `NotificationSender` operates uniformly without knowing concrete notification channels.
  - C: Adding new notification channels (`InAppNotification`) does not require modifying `NotificationSender`.

### Question 10
- **Answer:** **A, B, C**
- **Explanation:** Polymorphic collections allow uniform iteration, execute specialized behaviors dynamically, and eliminate type casting or conditional branching.

---

## Part 3: Concept Questions Solutions

### Question 1: Inheritance & Behavior Reuse
Inheritance lets a derived subclass inherit state (fields) and behavior (methods) from a base superclass. The subclass can reuse this logic as-is, extend it by adding new methods, or modify it by overriding existing methods.
*Business Example:* An `Account` base class handles `deposit()` and `getBalance()`. A `SavingsAccount` inherits these features and extends behavior by adding an `interestRate` field and an `addInterest()` method.

### Question 2: The 'is-a' Relationship
The 'is-a' relationship indicates that a subtype is a specialized version of a broader base type (e.g., a `Manager` IS-A `Employee`). Identifying genuine 'is-a' relationships ensures that the substitution principle (Liskov Substitution Principle) holds, preventing unexpected runtime errors and brittle class coupling.

### Question 3: Method Overriding
Method overriding allows a subclass to provide a specific implementation of a method already declared in its superclass.
*Business Example:* An `Employee` base class declares `calculateSalary()`. `FullTimeEmployee` overrides it to return `baseSalary + bonus`, while `ContractorEmployee` overrides it to return `hourlyRate * hoursWorked`.

### Question 4: Runtime Polymorphism & Dynamic Dispatch
Runtime polymorphism (dynamic dispatch) occurs when a method call is resolved at runtime based on the actual object type rather than the reference variable type. The Java Virtual Machine (JVM) inspects the virtual method table (vtable) of the target runtime object to execute the correct overridden implementation.

### Question 5: Polymorphic Collections
A polymorphic collection is a data structure (e.g., `List<Shape>`) typed to a base class or interface that contains instances of various derived classes (`Circle`, `Rectangle`, `Triangle`).
*Advantage:* It enables uniform processing of heterogeneous objects using a single loop (`shape.draw()`), promoting clean and decoupled code.

### Question 6: Polymorphism vs. Conditional Logic
Using polymorphism replaces monolithic `if-else if` or `switch` statements with object delegation. Polymorphism adheres to the Open-Closed Principle (OCP); adding a new type requires creating a new subclass without modifying existing control loops, whereas conditional logic requires editing code in multiple places.

### Question 7: Extensibility via Polymorphism
When a base type `PaymentMethod` defines an abstract method `processPayment()`, existing processing engines loop over `List<PaymentMethod>`. Adding a new type `CryptoPayment` only requires implementing `CryptoPayment extends PaymentMethod`. The processing engine remains untouched.

### Question 8: Inherited vs. Overridden Behavior
- **Inherited Behavior:** Used when the default base implementation is completely sufficient for the derived class (e.g., `Car.getSerialNumber()`).
- **Overridden Behavior:** Used when the derived class requires specialized or customized behavior (e.g., `ElectricCar.fillFuel()` overriding to charge battery).

### Question 9: Risks of Misusing Inheritance for Code Reuse
Inheriting from a class without an 'is-a' relationship creates tight coupling, exposes unwanted superclass internal details to subclasses, and breaks encapsulation. For code reuse between unrelated classes, composition (delegation) is preferred.

### Question 10: Modeling Vehicle Rental Systems
- **Common Behaviors (Base Class `VehicleRental`):** `calculateBaseRentalFee()`, `getRentalDuration()`, `isAvailable()`.
- **Specialized Behaviors (Derived Classes):**
  - `CarRental`: Adds passenger insurance fee.
  - `TruckRental`: Adds cargo weight capacity surcharge.
Inheritance centralizes common pricing/booking attributes in `VehicleRental` while allowing derived classes to enforce vehicle-specific rates.
