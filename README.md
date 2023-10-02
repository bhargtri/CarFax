# Car Management System (CarFax)

This README file provides an overview of the Car Management System, including user stories and descriptions of the services provided by the `CarService` and `OwnerService` classes.

## User Stories

### CarService

1. As a car dealership employee, I want to be able to insert a new car into the system so that I can add cars to our inventory.

2. As a car dealership employee, I want to retrieve a list of cars based on their make, so I can quickly find cars of a specific brand.

3. As a car dealership employee, I want to retrieve a list of cars based on their model, so I can find cars with a specific model.

4. As a car dealership employee, I want to retrieve a list of cars based on their color, so I can find cars of a particular color.

5. As a car dealership employee, I want to retrieve a list of cars based on their model year, so I can find cars from a specific year.

6. As a car dealership employee, I want to retrieve a list of cars with a clean title (no accidents), so I can provide this information to potential buyers.

7. As a car dealership employee, I want to retrieve a list of cars based on both their make and model, so I can find cars that match specific criteria.

8. As a car dealership employee, I want to retrieve a list of cars based on their model year and color, so I can find cars that meet specific preferences.

9. As a car dealership employee, I want to retrieve a list of cars built before a certain year, so I can find older cars in the inventory.

10. As a car dealership employee, I want to retrieve a list of all cars in the inventory, so I can view the entire stock.

11. As a car dealership employee, I want to retrieve detailed information about a car using its VIN (Vehicle Identification Number), so I can provide specific details to potential buyers.

12. As a car dealership employee, I want to update the title status of a car, indicating whether it has a clean title or not.

13. As a car dealership employee, I want to delete a car record from the system when a car is sold or removed from the inventory.

14. As a car dealership employee, I want to retrieve a list of cars based on the license number of their owner, so I can identify cars owned by the same person.

15. As a car dealership employee, I want to retrieve a list of cars from the most common make in our inventory.

16. As a car dealership employee, I want to retrieve a map of car makes and their average prices, so I can provide pricing information to potential buyers.

17. As a car dealership employee, I want to retrieve a list of cars with prices lower than a specified amount, so I can offer budget-friendly options to customers.

18. As a car dealership employee, I want to retrieve a list of cars with prices within a specified price range, so I can find cars within a customer's budget.

### OwnerService

1. As a car dealership employee, I want to insert owner information into the system when a new car owner is added, so I can maintain records of car ownership.

2. As a car dealership employee, I want to delete owner records from the system when a car owner is no longer associated with a car, so I can keep ownership information up-to-date.

3. As a car dealership employee, I want to retrieve a list of all car owners in the system, so I can access owner information when needed.

4. As a car dealership employee, I want to retrieve a list of car owners based on their state of residence, so I can identify owners within a specific region.

5. As a car dealership employee, I want to retrieve a list of car owners who are older than a certain age, so I can identify older car owners for targeted marketing or communication.

## Description

The Car Management System includes two services: `CarService` and `OwnerService`.

### CarService

The `CarService` class provides functionalities related to car management, including inserting new cars, retrieving cars by various criteria, updating car information, and more.

### OwnerService

The `OwnerService` class manages owner-related functionalities, such as inserting and deleting owner records, retrieving owner information, and filtering owners based on certain criteria.

These services are designed to help car dealership employees efficiently manage their car inventory and owner information. The user stories above outline the main tasks and functionalities supported by each service.

## Java Code

The Java code provided in the package includes two classes: `CarDAO` and `OwnerDAO`. These classes are responsible for database operations related to cars and owners, respectively. They interact with the database to perform operations such as inserting records, retrieving data, and deleting records.

