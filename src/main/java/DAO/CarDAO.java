package DAO;

import Model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarDAO {

    private Connection conn;

    public CarDAO(Connection conn){
        this.conn = conn;
    }

    public void insertCarRecord(Car car){
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Car (vin, model, make, model_year, color, clean_title) VALUES (?,?,?,?,?,?)");
            ps.setInt(1, car.getVin());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getMake());
            ps.setInt(4, car.getModelYear());
            ps.setString(5, car.getColor());
            ps.setBoolean(6, car.isCleanTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
