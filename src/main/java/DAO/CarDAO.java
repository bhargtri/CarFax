package DAO;

import Model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDAO {

    private Connection conn;

    public CarDAO(Connection conn){
        this.conn = conn;
    }

    
    public void insertCarRecord(Car car){
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Car (vin, model, make, model_year, color, clean_title, license_num, price) VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1, car.getVin());
            ps.setString(2, car.getModel());
            ps.setString(3, car.getMake());
            ps.setInt(4, car.getModelYear());
            ps.setString(5, car.getColor());
            ps.setBoolean(6, car.isCleanTitle());
            ps.setInt(7, car.getLicenseNum());
            ps.setDouble(8, car.getPrice());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> queryCarByMake(String make){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Car WHERE make = ?");
            ps.setString(1, make);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                int licenseNum = rs.getInt("license_num");
                double price = rs.getDouble("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle, licenseNum, price);
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
                int licenseNum = rs.getInt("license_num");
                double price = rs.getDouble("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle, licenseNum, price);
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
                int licenseNum = rs.getInt("license_num");
                double price = rs.getDouble("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, carColor, cleanTitle, licenseNum, price);
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
                int licenseNum = rs.getInt("license_num");
                double price = rs.getDouble("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle, licenseNum, price);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarIfCleanTitle(){
        List<Car> carList = new ArrayList<>();
        try{
            int value = 1;
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE clean_title = ?");
            ps.setInt(1, value);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                int licenseNum = rs.getInt("license_num");
                double price = rs.getInt("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle, licenseNum, price);
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
                int licenseNum = rs.getInt("license_num");
                double price = rs.getDouble("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle, licenseNum, price);
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
                int licenseNum = rs.getInt("license_num");
                double price = rs.getInt("price");
                Car dbCar = new Car(vin, dbMake, dbModel, dbModelYear, dbColor, cleanTitle, licenseNum, price);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public void updateTitleStatus(int vin, boolean status){
        try{
            int value;
            if(status){
                value = 1;
            }
            else value = 0;
            PreparedStatement ps = conn.prepareStatement("UPDATE car SET clean_title = ? WHERE vin = ?");
            ps.setInt(1, vin);
            ps.setInt(2, value);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Car> queryCarBeforeYear(int year) {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE model_year < ? ORDER BY model_year DESC");
            ps.setInt(1, year);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"), rs.getInt("license_num"), rs.getDouble("price"));
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
                        rs.getString("color"), rs.getBoolean("clean_title"), rs.getInt("license_num"), rs.getDouble("price"));
                carList.add(dbCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
    public Car queryCarByVin(int vin) {
        Car dbCar = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE vin = ?");
            ps.setInt(1, vin);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"), rs.getInt("license_num"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbCar;
    }

    public void deleteCarRecord(int vin){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Car WHERE vin = ?");
            ps.setInt(1, vin);
            System.out.println("The entry was deleted: " + ps.execute());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> queryCarByLicenseNum(int license){
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE license_num = ?");
            ps.setInt(1, license);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int vin = rs.getInt("vin");
                String dbModel = rs.getString("model");
                String dbMake = rs.getString("make");
                int modelYear = rs.getInt("model_year");
                String color = rs.getString("color");
                boolean cleanTitle = rs.getBoolean("clean_title");
                int licenseNum = rs.getInt("license_num");
                double price = rs.getInt("price");
                Car dbCar = new Car(vin, dbMake, dbModel, modelYear, color, cleanTitle, licenseNum, price);
                carList.add(dbCar);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return carList;
    }

    public Map<String, Integer> queryOfMakeCount(){
        Map<String, Integer> ofMakeCountMap = new HashMap<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT make, COUNT(make) AS count_make_listed FROM Car GROUP BY make");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ofMakeCountMap.put(rs.getString("make"), rs.getInt("count_make_listed"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ofMakeCountMap;
    }

    public double avgPricePerMake(String make)
    {
        double avgPrice = 0.0;
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT AVG(price) As avg FROM Car WHERE make = ? GROUP BY make");
            ps.setString(1,"make");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                avgPrice = rs.getDouble("avg");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return avgPrice;
    }

    public List<String> queryAllMake()
    {
        List<String> allMakes = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT make FROM Car");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tmp = rs.getString("make");
                allMakes.add(tmp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allMakes;
    }

    public List<Car> queryCarCheaperThan(double cost) {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE price < ? ORDER BY price DESC");
            ps.setDouble(1, cost);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"), rs.getInt("license_num"), rs.getDouble("price"));
                carList.add(dbCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

    public List<Car> queryCarInRange(double min, double max) {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM car WHERE price > ? AND price < ? ORDER BY price DESC");
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Car dbCar = new Car(rs.getInt("vin"), rs.getString("model"), rs.getString("make"), rs.getInt("model_year"),
                        rs.getString("color"), rs.getBoolean("clean_title"), rs.getInt("license_num"), rs.getDouble("price"));
                carList.add(dbCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }

}
