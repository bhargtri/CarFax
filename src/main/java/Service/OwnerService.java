package Service;

import DAO.OwnerDAO;
import Model.Car;
import Model.Owner;

import java.util.List;

public class OwnerService {

    OwnerDAO ownerDAO;

    public OwnerService(OwnerDAO ownerDao){
        this.ownerDAO = ownerDao;
    }

    public Owner insertOwner(Owner owner){
        int license = 0;
        do{
            license = (int) (Math.random() * Integer.MAX_VALUE);
        } while(ownerDAO.queryOwnerByLicenseNum(license) != null);

        owner.setLicenseNum(license);

        ownerDAO.insertOwnerRecord(owner);

        return owner;
    }

    public void deleteOwnerRecord(int licenseNum){
        ownerDAO.deleteOwnerRecord(licenseNum);
    }

    public List<Owner> getAllOwners(){
        return ownerDAO.queryAllOwners();
    }

    public List<Owner> getOwnersByState(String state){
        return ownerDAO.queryOwnersByState(state);
    }

    public List<Owner> getOwnersOlderThanAge(int age){
        return ownerDAO.queryOwnersOlderThanAge(age);
    }

}
