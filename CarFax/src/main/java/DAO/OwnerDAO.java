package DAO;

import Model.Owner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerDAO {
    private final Connection conn;

    public OwnerDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertOwnerRecord(Owner owner) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO owner (licenseNumber, name, birth_year, state) VALUES (?,?,?,?)")) {
            ps.setInt(1, owner.getLicenseNum());
            ps.setString(2, owner.getName());
            ps.setInt(3, owner.getBirthYear());
            ps.setString(4, owner.getState());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLicenseNumByName(String name) {
        try (PreparedStatement ps = conn.prepareStatement("SELECT licenseNumber FROM owner WHERE name = ?")) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("licenseNumber");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Owner> getOwnersByState(String ownerState) {
        List<Owner> ownerList = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM owner WHERE state = ?")) {
            ps.setString(1, ownerState);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Owner dbOwner = new Owner(rs.getInt("licenseNumber"), rs.getString("name"), rs.getInt("birth_year"), rs.getString("state"));
                    ownerList.add(dbOwner);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerList;
    }

    public List<Owner> getOwnersOlderThanAge(int age) {
        List<Owner> ownerList = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM owner WHERE YEAR(2023 - birth_year) > ?")) {
            ps.setInt(1, age);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Owner dbOwner = new Owner(rs.getInt("licenseNumber"), rs.getString("name"), rs.getInt("birth_year"), rs.getString("state"));
                    ownerList.add(dbOwner);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ownerList;
    }
}
