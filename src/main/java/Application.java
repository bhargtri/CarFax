import DAO.CarDAO;
import DAO.OwnerDAO;
import Model.Car;
import Model.Owner;
import Service.LookupCar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Replace with your database connection details
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String dbUser = "your_username";
        String dbPassword = "your_password";

        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Create DAO instances
            CarDAO carDAO = new CarDAO(conn);
            OwnerDAO ownerDAO = new OwnerDAO(conn);

            // Create a LookupCar service instance
            LookupCar lookupCar = new LookupCar();

            // Example 1: Look up a car by VIN
            int vinToLookup = 12345; // Replace with the VIN you want to look up
            Car foundCar = lookupCar.findCarByVIN(vinToLookup);
            if (foundCar != null) {
                System.out.println("Car found by VIN:");
                System.out.println(foundCar);
            } else {
                System.out.println("Car not found by VIN.");
            }

            // Example 2: Look up an owner by SSN
            int ssnToLookup = 123456789; // Replace with the SSN you want to look up
            Owner foundOwner = ownerDAO.getOwnerBySSN(ssnToLookup);
            if (foundOwner != null) {
                System.out.println("Owner found by SSN:");
                System.out.println(foundOwner);
            } else {
                System.out.println("Owner not found by SSN.");
            }

            // Example 3: Look up cars with similar attributes (e.g., same make and model)
            String makeToLookup = "Toyota"; // Replace with the make you want to search for
            String modelToLookup = "Camry"; // Replace with the model you want to search for
            List<Car> similarCars = lookupCar.findCarsByModel(makeToLookup, modelToLookup);
            if (!similarCars.isEmpty()) {
                System.out.println("Cars with similar make and model:");
                for (Car car : similarCars) {
                    System.out.println(car);
                }
            } else {
                System.out.println("No cars found with similar make and model.");
            }

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
