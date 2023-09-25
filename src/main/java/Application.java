import Model.Car;
import Model.Owner;
import Service.CarService;
import Service.OwnerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Replace these with your database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
       String username = "your_username";
       String password = "your_password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl,username, password)) {
            CarService carService = new CarService();
            OwnerService ownerService = new OwnerService(conn);

            // Search for cars based on criteria
            List<Car> matchingCars = carService.searchCars(0, "ModelX", "Tesla", 2022, "Blue", true);

            if (!matchingCars.isEmpty()) {
                System.out.println("Matching Cars:");
                for (Car car : matchingCars) {
                    System.out.println(car);
                }
            } else {
                System.out.println("No cars match the criteria.");
            }

            // Check if a car has a clean title
            Car carToCheck = new Car(123456, "ModelY", "Tesla", 2023, "Red", true);
            boolean hasCleanTitle = carService.hasCleanTitle(carToCheck);

            if (hasCleanTitle) {
                System.out.println("The car has a clean title.");
            } else {
                System.out.println("The car does not have a clean title.");
            }

            // Search for owners based on criteria
            List<Owner> matchingOwners = ownerService.getOwnersByState("California");

            if (!matchingOwners.isEmpty()) {
                System.out.println("Matching Owners:");
                for (Owner owner : matchingOwners) {
                    System.out.println(owner);
                }
            } else {
                System.out.println("No owners match the criteria.");
            }

            // You can use other methods provided by OwnerService as needed
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
