package Service;

import DAO.OwnerDAO;
import Exceptions.CarAlreadyExistsException;
import Exceptions.OwnerAlreadyExistsException;
import Exceptions.OwnerDoesNotExistException;
import Model.Car;
import Model.Owner;

import java.util.List;

public class OwnerService {

    OwnerDAO ownerDAO;

    public OwnerService(OwnerDAO ownerDao){
        this.ownerDAO = ownerDao;
    }

    public void insertOwner(Owner owner) throws OwnerAlreadyExistsException {
//        int license = 0;
//        do{
//            license = (int) (Math.random() * Integer.MAX_VALUE);
//        } while(ownerDAO.queryOwnerByLicenseNum(license) != null);
//
//        owner.setLicenseNum(license);
//
//        ownerDAO.insertOwnerRecord(owner);
//
//        return owner;
        Owner tempOwner = ownerDAO.queryOwnerByLicenseNum(owner.getLicenseNum());

        if(tempOwner == null){
            ownerDAO.insertOwnerRecord(owner);
        }else{
            throw new OwnerAlreadyExistsException();
        }
    }

    public void deleteOwnerRecord(int licenseNum) throws OwnerDoesNotExistException {
        if(ownerDAO.queryOwnerByLicenseNum(licenseNum) != null)
            ownerDAO.deleteOwnerRecord(licenseNum);
        else
            throw new OwnerDoesNotExistException();
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
