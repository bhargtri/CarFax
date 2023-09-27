package Service;

import DAO.CarDAO;
import Model.Car;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class CarService {
    CarDAO carDAO;

    public CarService(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    /**
     * Insert a new entry of type 'Car' into the table 'Car'
     * @param car
     * @return car
     */
    public Car insertCar(@NotNull Car car){
        int vin = 0;
        do{
            vin = (int) (Math.random() * Integer.MAX_VALUE);
        } while(carDAO.queryCarByVin(vin) != null);

        car.setVin(vin);

        carDAO.insertCarRecord(car);

        return car;
    }

    public List<Car> getCarsByMake(String make){
        return carDAO.queryCarByMake(make);
    }

    public List<Car> getCarsByModel(String model){
        return carDAO.queryCarByModel(model);
    }

    public List<Car> getCarsByColor(String color){
        return carDAO.queryCarByColor(color);
    }

    public List<Car> getCarsByModelYear(int modelYear){
        return carDAO.queryCarByModelYear(modelYear);
    }

    public List<Car> getCarsIfCleanTitle(){
        return carDAO.queryCarIfCleanTitle();
    }

    public List<Car> getCarsByMakeAndModel(String make, String model){
        return carDAO.queryCarByMakeAndModel(make, model);
    }

    public List<Car> getCarsByModelYearAndColor(int year, String color){
        return carDAO.queryCarByModelYearAndColor(year, color);
    }

    public List<Car> getCarsBeforeYear(int year){
        return carDAO.queryCarBeforeYear(year);
    }

    public List<Car> getAllCars(){
        return carDAO.queryAllCars();
    }

    public Car getCarByVin(int vin){
        return carDAO.queryCarByVin(vin);
    }

    public void updateTitleStatus(int vin, boolean status){
        carDAO.updateTitleStatus(vin, status);
    }

    public void deleteCarRecord(int vin){
        carDAO.deleteCarRecord(vin);
    }

    public List<Car> getCarsByLicenseNum(int license){
        return carDAO.queryCarByLicenseNum(license);
    }

    public List<Car> getCarsOfMostCommonMake() {
        Map<String, Integer> makeCountMap = carDAO.queryOfMakeCount();
        String currentMaxSoldMake = "na";
        int currentMaxCount = 0;
        for(Map.Entry<String, Integer> element : makeCountMap.entrySet()){
            if(element.getValue() > currentMaxCount){
                currentMaxSoldMake = element.getKey();
                currentMaxCount = element.getValue();
            }
        }
//        List<Car> carsOfMostCommonMake = carDAO.queryCarByMake(currentMaxSoldMake);
//        return carsOfMostCommonMake;
        return carDAO.queryCarByMake(currentMaxSoldMake);
    }


}
