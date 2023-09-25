package Service;

import Model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarService {

    public CarService() {
    }

    // Method to search for cars based on criteria
    public List<Car> searchCars(int vin, String model, String make, int modelYear, String color, boolean cleanTitle) {
        List<Car> matchingCars = new ArrayList<>();
        Connection conn = null;
        try {
            // Customize the SQL query based on the provided criteria
            String sql = "SELECT * FROM Car WHERE 1=1"; // Start with a basic query

            if (vin != 0) {
                sql += " AND vin = ?";
            }
            if (model != null && !model.isEmpty()) {
                sql += " AND model = ?";
            }
            if (make != null && !make.isEmpty()) {
                sql += " AND make = ?";
            }
            if (modelYear != 0) {
                sql += " AND model_year = ?";
            }
            if (color != null && !color.isEmpty()) {
                sql += " AND color = ?";
            }
            if (cleanTitle) {
                sql += " AND clean_title = true";
            }
            PreparedStatement ps = conn.prepareStatement(sql);

            int parameterIndex = 1;

            if (vin != 0) {
                ps.setInt(parameterIndex++, vin);
            }
            if (model != null && !model.isEmpty()) {
                ps.setString(parameterIndex++, model);
            }
            if (make != null && !make.isEmpty()) {
                ps.setString(parameterIndex++, make);
            }
            if (modelYear != 0) {
                ps.setInt(parameterIndex++, modelYear);
            }
            if (color != null && !color.isEmpty()) {
                ps.setString(parameterIndex++, color);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Create Car objects and add them to matchingCars list
                Car car = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"), rs.getString("color"), rs.getBoolean("clean_title"));
                matchingCars.add(car);
            }

            // Close the PreparedStatement and ResultSet
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return matchingCars;
    }

    // Method to declare whether a car has a clean title or not
    public boolean hasCleanTitle(Car car) {
        return car.isCleanTitle();
    }
}
