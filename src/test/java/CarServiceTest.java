import DAO.CarDAO;
import Exceptions.CarAlreadyExistsException;
import Exceptions.CarDoesNotExistsException;
import Model.Car;
import Service.CarService;
import Util.ConnectionSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.anyInt;

public class CarServiceTest {
    CarService carService;
    CarDAO mockCarDAO;

    @Before
    public void setup(){
        mockCarDAO = Mockito.mock(CarDAO.class);
        carService = new CarService(mockCarDAO);
    }

    /**
     * Each car has a unique vin, using which we can try to insert a car. If car does not exist in table, insert should happen and there should only be 1 insert call made.
     * @throws CarDoesNotExistsException
     */
    @Test
    public void insertCarSuccessfulTest() throws CarAlreadyExistsException {
        Car car = new Car(1234, "NSX", "Acura", 1995, "red", true,123456, 250000);

        Mockito.when(mockCarDAO.queryCarByVin(anyInt())).thenReturn(null);


        carService.insertCar(car);

        Mockito.verify(mockCarDAO, Mockito.times(1)).insertCarRecord(car);
    }

    /**
     * Each car has a unique vin, using which we can try to insert a car. If car exists in table, insert should not happen and there should be an exception.
     * @throws CarDoesNotExistsException
     */
    @Test(expected = CarAlreadyExistsException.class)
    public void insertCarUnsuccessfulTest() throws CarAlreadyExistsException {
        Car car = new Car(1234, "NSX", "Acura", 1995, "red", true,123456, 250000);

        Mockito.when(mockCarDAO.queryCarByVin(anyInt())).thenReturn(new Car());


        carService.insertCar(car);

    }
    /**
     * Each car has a unique vin, using which we can change its cleanTitle status. There should only be 1 call made.
     * @throws CarDoesNotExistsException
     */
//    @Test
//    public void updateTitleStatusTest() throws CarDoesNotExistsException {
//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car(1234, "NSX", "Acura", 1995, "red", true,123456, 250000));
//        carList.add(new Car(2671, "911 GT3", "Porsche", 2018, "silver", true,469756, 315000));
//        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
//
//        Mockito.when(mockCarDAO.queryAllCars()).thenReturn(carList);
//        System.out.println(mockCarDAO.queryAllCars());
//
//        carService.updateTitleStatus(1234, false);
//
//        Mockito.verify(mockCarDAO, Mockito.times(1)).updateTitleStatus(1234, false);
//    }
//
//    /**
//     * Each car has a unique vin, using which we can delete it. There should only be 1 call made.
//     * @throws CarDoesNotExistsException
//     */
//    @Test
//    public void deletecarRecordTest() throws CarDoesNotExistsException {
//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car(1234, "NSX", "Acura", 1995, "red", true,123456, 250000));
//        carList.add(new Car(2671, "911 GT3", "Porsche", 2018, "silver", true,469756, 315000));
//        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
//
//        Mockito.when(mockCarDAO.queryAllCars()).thenReturn(carList);
//        System.out.println(mockCarDAO.queryAllCars());
//
//        carService.deleteCarRecord(1234);
//
//        Mockito.verify(mockCarDAO, Mockito.times(1)).deleteCarRecord(1234);
//    }

    @Test
    public void updateTitleStatusTest() throws CarDoesNotExistsException {
        int vin = 12345;
        boolean newStatus = false;
        Mockito.when(mockCarDAO.queryCarByVin(vin)).thenReturn(new Car());

        carService.updateTitleStatus(vin, newStatus);

        Mockito.verify(mockCarDAO, Mockito.times(1)).updateTitleStatus(vin, newStatus);
    }

    @Test(expected = CarDoesNotExistsException.class)
    public void updateTitleStatusCarDoesNotExistTest() throws CarDoesNotExistsException {
        int vin = 12345;
        boolean newStatus = false;
        Mockito.when(mockCarDAO.queryCarByVin(vin)).thenReturn(null);

        carService.updateTitleStatus(vin, newStatus);

    }

    /**
     * Each car has a unique vin, using which we can delete it. There should only be 1 call made.
     * @throws CarDoesNotExistsException
     */
    @Test
    public void deleteCarRecordTest() throws CarDoesNotExistsException {
        int vin = 12345;
        Mockito.when(mockCarDAO.queryCarByVin(vin)).thenReturn(new Car());

        carService.deleteCarRecord(vin);

        Mockito.verify(mockCarDAO, Mockito.times(1)).deleteCarRecord(vin);
    }

    @Test(expected = CarDoesNotExistsException.class)
    public void deleteCarRecordDoesNotExistTest() throws CarDoesNotExistsException {
        int vin = 12345;
        Mockito.when(mockCarDAO.queryCarByVin(vin)).thenReturn(null);

        carService.deleteCarRecord(vin);

        Mockito.verify(mockCarDAO, Mockito.times(1)).deleteCarRecord(vin);
    }

    @Test
    public void getByMakeTest(){
        String make = "BMW";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByMake(make)).thenReturn(carList);

        List<Car> result = carService.getCarsByMake(make);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByModelTest(){
        String model = "M2";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByModel(model)).thenReturn(carList);

        List<Car> result = carService.getCarsByModel(model);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByColorTest(){
        String color = "grey";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByColor(color)).thenReturn(carList);

        List<Car> result = carService.getCarsByColor(color);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByModelYearTest(){
        int modelYear = 1989;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByModelYear(modelYear)).thenReturn(carList);

        List<Car> result = carService.getCarsByModelYear(modelYear);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByCleanTitleTest(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", true,982546, 80000));
        Mockito.when(mockCarDAO.queryCarIfCleanTitle()).thenReturn(carList);

        List<Car> result = carService.getCarsIfCleanTitle();

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByMakeAndModelTest(){
        String make = "BMW";
        String model = "M2";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByMakeAndModel(make,model)).thenReturn(carList);

        List<Car> result = carService.getCarsByMakeAndModel(make,model);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByModelYearAndColorTest(){
        int modelYear = 1989;
        String color = "grey";
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByModelYearAndColor(modelYear, color)).thenReturn(carList);

        List<Car> result = carService.getCarsByModelYearAndColor(modelYear, color);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getCarsBeforeYearTest(){
        int year = 1990;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarBeforeYear(year)).thenReturn(carList);

        List<Car> result = carService.getCarsBeforeYear(year);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getByVINTest(){
        int vin = 9270;
        Car car = new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000);
        Mockito.when(mockCarDAO.queryCarByVin(vin)).thenReturn(car);

        Car result = carService.getCarByVin(vin);

        Assert.assertEquals(car, result);
    }

    @Test
    public void getByLicenseNumTest(){
        int licenseNum = 982546;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarByLicenseNum(licenseNum)).thenReturn(carList);

        List<Car> result = carService.getCarsByLicenseNum(licenseNum);

        Assert.assertEquals(carList, result);
    }

//COULD NOT FIGURE OUT HOW TO SET UP MOCKITO FOR CarDAO getByMostCommonMake.
//    public void getByMostCommonMakeTest(){
//        List<Car> carList = new ArrayList<>();
//        Mockito.when(mockCarDAO.queryCarsOfMostCMake(make)).thenReturn(carList);
//
//        List<Car> result = carService.getCarsOfMostCommonMake(make);
//
//        Assert.assertEquals(carList, result);
//    }

    @Test
    public void getAvgPriceOfMakeTest(){
        List<String> listOfMakes = new ArrayList<>();
        listOfMakes.add("BMW");
        listOfMakes.add("Porsche");

        Mockito.when(mockCarDAO.queryAllMake()).thenReturn(listOfMakes);
        Mockito.when(mockCarDAO.avgPricePerMake("BMW")).thenReturn(150000.0);
        Mockito.when(mockCarDAO.avgPricePerMake("Porsche")).thenReturn(200000.0);

        Map<String, Double> avgPriceMap = carService.getAvgPricePerMake();

        Map<String, Double> expectedAvgPriceMap = new HashMap<>();
        expectedAvgPriceMap.put("BMW", 150000.0);
        expectedAvgPriceMap.put("Porsche", 200000.0);

        Assert.assertEquals(avgPriceMap, expectedAvgPriceMap);

    }

    @Test
    public void getCarsCheaperThanTest(){
        int price = 81000;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarCheaperThan(price)).thenReturn(carList);

        List<Car> result = carService.getCarsCheaperThan(price);

        Assert.assertEquals(carList, result);
    }

    @Test
    public void getCarsInRangeTest(){
        int min = 79000;
        int max = 81000;
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(9270, "M2", "BMW", 1989, "grey", false,982546, 80000));
        Mockito.when(mockCarDAO.queryCarInRange(min, max)).thenReturn(carList);

        List<Car> result = carService.getCarsInRange(min, max);

        Assert.assertEquals(carList, result);
    }

    @After
    public void tearDown(){
        ConnectionSingleton.resetTestDatabase();
    }



}
