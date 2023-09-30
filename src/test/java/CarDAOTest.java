import DAO.CarDAO;
import Model.Car;
import Util.ConnectionSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

public class CarDAOTest {
    Connection conn;
    CarDAO carDAO;

    @Before
    public void setup(){
        conn = ConnectionSingleton.getConnection();
        carDAO = new CarDAO(conn);
    }

    @Test
    public void insertCarTest(){
        Car car = new Car(1243, "Civic", "Honda", 1998, "grey", true, 123456, 12000);
        carDAO.insertCarRecord(car);
        Car retrievedCar = carDAO.queryCarByVin(1243);
        Assert.assertEquals(car, retrievedCar);
    }
    @Test
    public void getByMakeTest(){
        List<Car> car = carDAO.queryCarByMake("Ferrari");
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByMake("Toyota");
        Assert.assertTrue(car2.isEmpty());

    }

    @Test
    public void getByModelTest(){
        List<Car> car = carDAO.queryCarByModel("911 GT3");
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByModel("Punto");
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void getByColorTest(){
        List<Car> car = carDAO.queryCarByColor("red");
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByColor("orange");
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void getByModelYearTest(){
        List<Car> car = carDAO.queryCarByModelYear(1995);
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByModelYear(1990);
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void getByMakeAndModelTest(){
        List<Car> car = carDAO.queryCarByMakeAndModel("Ferrari","F50");
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByMakeAndModel("Fiat", "Punto");
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void getByModelYearAndColorTest(){
        List<Car> car = carDAO.queryCarByModelYearAndColor(1995,"red");
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByModelYearAndColor(1998, "blue");
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void updateTitleStatusTest(){
        carDAO.updateTitleStatus(1234, false);
        Car car = carDAO.queryCarByVin(1234);
        Assert.assertFalse(car.isCleanTitle());
    }

    @Test
    public void carBeforeYearTest(){
        List<Car> car = carDAO.queryCarBeforeYear(1990);
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarBeforeYear(1800);
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void getAllCarsTest(){
        List<Car> car = carDAO.queryAllCars();
        Assert.assertFalse(car.isEmpty());
    }

    @Test
    public void getByVINTest(){
        Car car = carDAO.queryCarByVin(1234);
        Assert.assertNotNull(car);
        Car car2 = carDAO.queryCarByVin(1990);
        Assert.assertNull(car2);
    }
    @Test
    public void deleteCarTest(){
        Car car = carDAO.queryCarByVin(1234);
        Assert.assertNotNull(car);
        carDAO.deleteCarRecord(1234);
        Car car2 = carDAO.queryCarByVin(1234);
        Assert.assertNull(car2);
    }

    @Test
    public void getByLicenseNum(){
        List<Car> car = carDAO.queryCarByLicenseNum(123456);
        Assert.assertFalse(car.isEmpty());
        List<Car> car2 = carDAO.queryCarByLicenseNum(123489);
        Assert.assertTrue(car2.isEmpty());
    }

    @Test
    public void queryOfMakeCountTest(){
        Assert.assertEquals(6, carDAO.queryOfMakeCount().size());
    }

    @Test
    public void avgPricePerMakeTest(){
        Assert.assertEquals(512500.0, carDAO.avgPricePerMake("Ferrari"), 0.2);
    }

    @Test
    public void queryAllMakeTest(){
        List<String> makeList = carDAO.queryAllMake();
        Assert.assertEquals(6, makeList.size());
    }

    @Test
    public void queryCheaperThan(){
        List<Car> carList = carDAO.queryCarCheaperThan(90000.0);
        Assert.assertEquals(2, carList.size());
    }

    @Test
    public void queryInRange(){
        List<Car> carList = carDAO.queryCarInRange(59000.0, 81000.0);
        Assert.assertEquals(2, carList.size());
    }

    @After
    public void tearDown(){
        ConnectionSingleton.resetTestDatabase();
    }
}
