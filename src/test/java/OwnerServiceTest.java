import DAO.CarDAO;
import DAO.OwnerDAO;
import Exceptions.OwnerAlreadyExistsException;
import Exceptions.OwnerDoesNotExistException;
import Model.Owner;
import Service.OwnerService;
import Util.ConnectionSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class OwnerServiceTest {

    OwnerService ownerService;
    OwnerDAO mockOwnerDao;

    @Before
    public void setup(){
        mockOwnerDao = Mockito.mock(OwnerDAO.class);
        ownerService = new OwnerService(mockOwnerDao);
    }

    @Test
    public void insertOwnerTest() throws OwnerAlreadyExistsException {
        Owner owner = new Owner();
        owner.setLicenseNum(56789);

        Mockito.when(mockOwnerDao.queryOwnerByLicenseNum(56789)).thenReturn(null);

        ownerService.insertOwner(owner);

        Mockito.verify(mockOwnerDao, Mockito.times(1)).insertOwnerRecord(owner);
    }

    @Test
    public void insertOwnerThatAlreadyExistsTest() throws OwnerAlreadyExistsException {
        Owner owner = new Owner();
        owner.setLicenseNum(56789);

        Mockito.when(mockOwnerDao.queryOwnerByLicenseNum(56789)).thenReturn(owner);

        try{
            ownerService.insertOwner(owner);
            Assert.fail("Expected the OwnerAlreadyExistsException");
        }catch(OwnerAlreadyExistsException e){

        }
    }

    @Test
    public void deleteOwnerRecordTest() throws OwnerDoesNotExistException {
        int licenseNum = 56789;

        Mockito.when(mockOwnerDao.queryOwnerByLicenseNum(licenseNum)).thenReturn(new Owner());

        ownerService.deleteOwnerRecord(licenseNum);

        Mockito.verify(mockOwnerDao, Mockito.times(1)).deleteOwnerRecord(licenseNum);
    }

    @Test
    public void deleteOwnerRecordThatDoesNotExistTest() throws OwnerDoesNotExistException {
        int licenseNum = 56789;

        Mockito.when(mockOwnerDao.queryOwnerByLicenseNum(licenseNum)).thenReturn(null);

        try{
            ownerService.deleteOwnerRecord(licenseNum);

            Assert.fail("Expected OwnerDoesNotExistException");
        }catch(OwnerDoesNotExistException e){

        }
    }

    @Test
    public void testGetAllOwners(){
        List<Owner> ownerList = new ArrayList<>();
        Mockito.when(mockOwnerDao.queryAllOwners()).thenReturn(ownerList);

        List<Owner> result = ownerService.getAllOwners();

        Assert.assertEquals(ownerList, result);
    }

    @Test
    public void getOwnersByStateTest(){
        String state = "Maine";

        List<Owner> ownerList = new ArrayList<>();
        Mockito.when(mockOwnerDao.queryOwnersByState(state)).thenReturn(ownerList);

        List<Owner> result = ownerService.getOwnersByState(state);

        Assert.assertEquals(ownerList, result);
    }

    @Test
    public void getOwnersOlderThanTest(){
        int age = 100;
        List<Owner> ownerList = new ArrayList<>();
        Mockito.when(mockOwnerDao.queryOwnersOlderThanAge(age)).thenReturn(ownerList);

        List<Owner> result = ownerService.getOwnersOlderThanAge(age);

        Assert.assertEquals(ownerList, result);
    }
    @After
    public void tearDown(){
        ConnectionSingleton.resetTestDatabase();
    }


}
