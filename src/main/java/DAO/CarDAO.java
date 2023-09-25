package DAO;

import Model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Car> queryCarByMake(String make){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE make = ?");
            ps.setString(1, make);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarByModel(String model){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE model = ?");
            ps.setString(1, model);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarByColor(String color){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE color = ?");
            ps.setString(1, color);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String carColor = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, carColor, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarByModelYear(int year){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE model_year = ?");
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarByCleanTitle(boolean title){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE clean_title = ?");
            ps.setBoolean(1, title);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarByMakeAndModel(String make, String model){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE make = ? AND model = ?");
            ps.setString(1, make);
            ps.setString(2, model);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarByModelYearAndColor(int modelYear, String color){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE model_year = ? AND color = ?");
            ps.setInt(1, modelYear);
            ps.setString(2, color);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int dbModelYear = rs.getInt("model_year");
                String dbColor = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                Car dbCar = new Car(vin, dbMake, dbModel, dbModelYear, dbColor, cleanTitle);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

//    public void updateTitleStatus(int vin){
//        try{
//            PreparedStatement ps = conn.prepareStatement("UPDATE car SET clean_title = ? WHERE vin = ?");
//            ps.setBoolean(1, ps.getClean());
//            ps.setString(2, p.getTitle());
//            ps.executeUpdate();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }

    public List<Car> queryCarBeforeYear(int year) {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE model_year < ? ORDER BY model_year DESC");
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"));
                carList.add(dbCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryAllCars() {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car ORDER BY model_year DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"));
                carList.add(dbCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
    public List<Car> queryCarByVin(int vin) {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE vin = ?");
            ps.setInt(1, vin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"));
                carList.add(dbCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

}
