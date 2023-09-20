package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDAO {
    Connection conn;

    public DriverDAO(Connection conn){
        this.conn = conn;
    }

    public int getLicenseNumByName(String name){
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT license_num FROM author WHERE driver.name = ?");
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

}
