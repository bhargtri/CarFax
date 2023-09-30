import DAO.CarDAO;
import DAO.OwnerDAO;
import Model.Car;
import Model.Owner;
import Util.ConnectionSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class OwnerDAOTest {
    Connection conn;
    OwnerDAO ownerDAO;

    @Before
    public void setup(){
        conn = ConnectionSingleton.getConnection();
        ownerDAO = new OwnerDAO(conn);
    }

    @Test
    public void insertOwnerTest(){
        Owner owner = new Owner(123654, "Test", 1980, "California");
        ownerDAO.insertOwnerRecord(owner);
        Owner retrievedOwner = ownerDAO.queryOwnerByLicenseNum(123654);
        Assert.assertEquals(owner, retrievedOwner);

    }

    @Test
    public void deleteOwnerTest(){
        Owner owner = ownerDAO.queryOwnerByLicenseNum(124365);
        Assert.assertNotNull(owner);
        ownerDAO.deleteOwnerRecord(124365);
        Owner owner2 = ownerDAO.queryOwnerByLicenseNum(124365);
        Assert.assertNull(owner2);
    }

    @Test
    public void getByLicenseNumTest(){
        Owner owner = ownerDAO.queryOwnerByLicenseNum(123456);
        Assert.assertNotNull(owner);
        Owner owner2 = ownerDAO.queryOwnerByLicenseNum(199080);
        Assert.assertNull(owner2);
    }

    @Test
    public void getAllOwnersTest(){
        List<Owner> ownerList = ownerDAO.queryAllOwners();
        Assert.assertFalse(ownerList.isEmpty());
    }

    @Test
    public void getByOwnersByStateTest(){
        List<Owner> ownerList = ownerDAO.queryOwnersByState("Florida");
        Assert.assertFalse(ownerList.isEmpty());
        List<Owner> ownerList2 = ownerDAO.queryOwnersByState("Maryland");
        Assert.assertTrue(ownerList2.isEmpty());
    }

    @Test
    public void ownersOlderThanTest(){
        List<Owner> ownerList = ownerDAO.queryOwnersOlderThanAge(100);
        Assert.assertFalse(ownerList.isEmpty());
        List<Owner> ownerList2 = ownerDAO.queryOwnersOlderThanAge(200);
        Assert.assertTrue(ownerList2.isEmpty());
    }
    @After
    public void tearDown(){
        ConnectionSingleton.resetTestDatabase();
    }
}
