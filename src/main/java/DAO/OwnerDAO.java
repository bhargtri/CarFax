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

    public int getLicenseNumByName(String name){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT license_num FROM author WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("license_num");
                return id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public List<Owner> getOwnersByState(String ownerState){
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

    public List<Owner> getOwnersOlderThanAge(int age){
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
