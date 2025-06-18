# Domain Model - Iteration 0
This document defines the core entities and their relationships for the car dealership system. The focus is on delivering a functional minimum with essential data modeling and clear service boundaries.

## Entities

- Branch: Represents a branch location in a specific city and country.
- VehicleModel: Represents a car model with year, price, warranty period
- VehicleUnit: Represents vehicles (available, sold, reserved) in specific Branch or Central deposit (are VehicleModel with plate)
- Customer: Represents a person who purchases vehicles or requests services.
- Sale: Represents a vehicle sale operation, awarding a stock item to a customer. The vehicle should be marked as sold.
- MaintenanceService: Represents a mechanical service request for a vehicle with or without available warranty.

### Notes
- A `Sale` links a `Customer`, `VehicleUnit`, and `Branch`.
- A Vehicle in `VehicleUnit` may exist in branch stock or central stock (depending on its locationType).
- A `MaintenanceService` is associated with a `Customer` and a `VehicleUnit`.
- Warranty eligibility is calculated based on the VehicleModel's warranty period and the Sale date, compared to the MaintenanceService entry date.
- When `VehicleUnit.status` is `EXTERNAL`, the vehicle was not sold nor stocked by the company. It exists only to support maintenance of external vehicles.

## Entities attributes

### 🏢 Branch
- `id`: UUID
- `name`: String
- `country`: String
- `province`: String
- `city`: String
- `address`: String
- `openingDate`: LocalDate
- `localDeliveryTimeDays`: Integer
- `centralDeliveryTimeDays`: Integer

---

### 🚗 VehicleModel
- `id`: UUID
- `brand`: String
- `model`: String
- `manufactureYear`: Integer
- `type`: String (e.g. SUV, sedan)
- `price`: BigDecimal
- `warrantyYears`: Integer

> `brand`, `model` and `manufactureYear` are a combination that uniquely identifies a vehicle model. Not a primary key, but a unique constraint.
---

### 📦 VehicleUnit
- `id`: UUID
- `licensePlate`: String
- `color`: String
- `status`: VehicleUnitStatus as Enum[AVAILABLE, RESERVED, SOLD, EXTERNAL]
- `locationType`: LocationType (Enum[CENTRAL, BRANCH, EXTERNAL])
- `branch`: Optional<Branch> (FK) (nullable if locationType == CENTRAL)
- `vehicleModel`: VehicleModel (FK)
---

### 👤 Customer
- `id`: UUID
- `firstName`: String
- `lastName`: String
- `dni`: String
- `email`: String
- `phone`: String
- `address`: String

---

### 💰 Sale
**Attributes:**
- `id`: UUID
- `amount`: BigDecimal
- `saleDate`: LocalDate
- `customer`: Customer (FK)
- `vehicleUnit`: VehicleUnit (FK)
- `branch`: Branch (FK)

---

### 🛠️ MaintenanceService
**Attributes:**
- `id`: UUID
- `entryDate`: LocalDate
- `mileage`: Integer
- `isUnderWarranty`: Boolean
- `serviceType`: String (e.g. oil change, general inspection)
- `vehicleUnit`: VehicleUnit (FK)
- `customer`: Customer (FK)
