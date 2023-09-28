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
     * @return car - The entity entered.
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

    /**
     * Take a String 'make' as input and return all cars of that make.
     * @param make
     * @return list of cars of that make.
     */
    public List<Car> getCarsByMake(String make){
        return carDAO.queryCarByMake(make);
    }

    /**
     * Take a String 'model' as input and return all cars corresponding to that model.
     * @param model
     * @return list of cars of that model.
     */
    public List<Car> getCarsByModel(String model){
        return carDAO.queryCarByModel(model);
    }
    /**
     * Take a String 'color' as input and return all cars of that color.
     * @param color
     * @return list of cars of that color.
     */
    public List<Car> getCarsByColor(String color){
        return carDAO.queryCarByColor(color);
    }
    /**
     * Take an int 'modelYear' as input and return all cars of that model year.
     * @param modelYear
     * @return list of cars of that model.
     */
    public List<Car> getCarsByModelYear(int modelYear){
        return carDAO.queryCarByModelYear(modelYear);
    }
    /**
     * Return all cars that have a clean title(i.e. No accidents).
     * @return list of cars of that have a clean title.
     */
    public List<Car> getCarsIfCleanTitle(){
        return carDAO.queryCarIfCleanTitle();
    }
    /**
     * Take a String 'make' and another String 'model' as input and return all cars of that make and model.
     * @param make
     * @param model
     * @return list of cars of that make and model.
     */
    public List<Car> getCarsByMakeAndModel(String make, String model){
        return carDAO.queryCarByMakeAndModel(make, model);
    }
    /**
     * Take an int 'year' and a String 'color' as input and return all cars from that model year and of that color.
     * @param year
     * @param color
     * @return list of cars of that make and model.
     */
    public List<Car> getCarsByModelYearAndColor(int year, String color){
        return carDAO.queryCarByModelYearAndColor(year, color);
    }

    /**
     * Return a list of all cars from before that input year.
     * @param year
     * @return a list of cars built before the input year.
     */
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
