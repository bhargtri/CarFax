package Service;

import DAO.OwnerDAO;
import Model.Owner;

import java.sql.Connection;
import java.util.List;

public class OwnerService {
    private final OwnerDAO ownerDAO;

    public OwnerService(Connection conn) {
        this.ownerDAO = new OwnerDAO(conn);
    }

    public Owner getOwnerByName(String name) {
        int licenseNum = ownerDAO.getLicenseNumByName(name);
        if (licenseNum != 0) {
            return new Owner(licenseNum, name, 0, ""); // You can fill in other details or retrieve them from the database if needed
        }
        return null;
    }

    public List<Owner> getOwnersByState(String ownerState) {
        return ownerDAO.getOwnersByState(ownerState);
    }

    public List<Owner> getOwnersOlderThanAge(int age) {
        return ownerDAO.getOwnersOlderThanAge(age);
    }

    // You can add more methods for additional lookup criteria if needed
}
