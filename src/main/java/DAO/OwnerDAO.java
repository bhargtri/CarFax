package DAO;

import Model.Car;
import Model.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
    Connection conn;

    public OwnerDAO(Connection conn){
        this.conn = conn;
    }

    public void insertOwnerRecord(Owner owner){
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Owner (license_num, name, birthYear, state) VALUES (?,?,?,?)");
            ps.setInt(1, owner.getLicenseNum());
            ps.setString(2, owner.getName());
            ps.setInt(3, owner.getBirthYear());
            ps.setString(4, owner.getState());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOwnerRecord(int licenseNum){
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Owner WHERE license_num = ?");
            ps.setInt(1, licenseNum);
            System.out.println("The entry was deleted: " + ps.execute());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Owner> queryOwnerByLicenseNum(int license){
        List<Owner> ownerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Owner WHERE license_num = ?");
            ps.setInt(1, license);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int licenseNum = rs.getInt("license_num");
                String dbName = rs.getString("name");
                int birthYear = rs.getInt("birth_year");
                String state = rs.getString("state");
                Owner dbOwner = new Owner(licenseNum, dbName, birthYear, state);
                ownerList.add(dbOwner);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ownerList;
    }

    public List<Owner> queryAllOwners() {
        List<Owner> ownerList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Owner ORDER BY birth_year DESC");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Owner dbOwner = new Owner(rs.getInt("license_num"), rs.getString("name"), rs.getInt("birth_year"),
                        rs.getString("state"));
                ownerList.add(dbOwner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerList;
    }

    public List<Owner> queryOwnersByState(String ownerState){
        List<Owner> ownerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM owner WHERE state = ?");
            ps.setString(1, ownerState);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Owner dbOwner = new Owner(rs.getInt("licenseNumber"), rs.getString("name"), rs.getInt("birth_year"), rs.getString("state"));
                ownerList.add(dbOwner);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ownerList;
    }

    public List<Owner> queryOwnersOlderThanAge(int age){
        List<Owner> ownerList = new ArrayList<>();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM owner WHERE YEAR(2023-birth_year) > ?");
            ps.setInt(1, age);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Owner dbOwner = new Owner(rs.getInt("licenseNumber"), rs.getString("name"), rs.getInt("birth_year"), rs.getString("state"));
                ownerList.add(dbOwner);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ownerList;
    }

}
