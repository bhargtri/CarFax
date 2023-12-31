package Controller;

import Exceptions.CarAlreadyExistsException;
import Exceptions.CarDoesNotExistsException;
import Exceptions.OwnerAlreadyExistsException;
import Exceptions.OwnerDoesNotExistException;
import Model.Car;
import Model.Owner;
import Service.CarService;
import Service.OwnerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class CarFaxController {
    CarService carService;
    OwnerService ownerService;

    public CarFaxController(CarService carService, OwnerService ownerService)
    {
        this.carService = carService;
        this.ownerService = ownerService;
    }

    public Javalin listAPI()
    {
        Javalin app = Javalin.create();

        //Car URI's

        app.get("/car", this::getAllCarsHandler);
        app.get("/car/byMake/{make}", this::getCarByMakeHandler);
        app.get("/car/byModel/{model}", this::getCarByModelHandler);
        app.get("/car/byColor/{color}", this::getCarByColorHandler);
        app.get("/car/byModelYear/{modelYear}", this::getCarByModelYearHandler);
        app.get("/car/onlyCleanTitle", this::getCleanCarHandler);
        app.get("/car/byMakeAndModel", this::getCarByMakeAndModelHandler);
        app.get("/car/byModelYearAndColor", this::getCarByModelYearAndColorHandler);
        app.get("/car/beforeModelYear/{modelYear}", this::getCarBeforeModelYearHandler);
        app.get("/car/byVIN/{vin}", this::getCarByVINHandler);
        app.get("/car/byLicenseNumber/{licenseNumber}", this::getCarByLicenseNumberHandler);
        app.get("/car/avgPriceOfMake", this::getCarByAvgPricePerMakeHandler);
        app.get("/car/cheaperThan/{minPrice}", this::getCarCheaperThanHandler);
        app.get("/car/inRange", this::getCarInRangeOfHandler);
        app.get("/car/mostCommonMake", this::getCarOfMostCommonMake);

        app.post("/car", this::postCarHandler);
        app.post("/car/status", this::postCarCleanStatusHandler);

        app.delete("/car/{vin}", this::deleteCarHandler);

        //Owner URI's
        app.get("/owner", this::getAllOwnersHandler);
        app.get("/owner/byState/{state}", this::getOwnerByStateHandler);
        app.get("/owner/olderThanAge/{age}", this::getOwnersOlderThanAgeHandler);


        app.post("/owner", this::postOwnerHandler);

        app.delete("/owner/{licenseNum}", this::deleteOwnerHandler);


        return app;
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//Car API Handlers
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    private void getAllCarsHandler(Context context){
        context.json(carService.getAllCars());
    }
    private void getCarByMakeHandler(@NotNull Context context){
        String make = context.pathParam("make");
        List<Car> carList = carService.getCarsByMake(make);
        context.json(carList);
    }

    private void getCarByModelHandler(@NotNull Context context) {
        String model = context.pathParam("model");
        List<Car> carList = carService.getCarsByModel(model);
        context.json(carList);
    }

    private void getCarByColorHandler(@NotNull Context context) {
        String color = context.pathParam("color");
        List<Car> carList = carService.getCarsByColor(color);
        context.json(carList);
    }

    private void getCarByModelYearHandler(@NotNull Context context) {
        int modelYear = Integer.parseInt(context.pathParam("modelYear"));
        List<Car> carList = carService.getCarsByModelYear(modelYear);
        context.json(carList);
    }

    private void getCleanCarHandler(@NotNull Context context) {
        List<Car> carList = carService.getCarsIfCleanTitle();
        context.json(carList);
    }

    private void getCarByMakeAndModelHandler(@NotNull Context context) {
        String make = context.queryParam("make");
        String model = context.queryParam("model");
        List<Car> carList = carService.getCarsByMakeAndModel(make,model);
        context.json(carList);
    }

    private void getCarByModelYearAndColorHandler(@NotNull Context context) {
        int modelYear = Integer.parseInt(context.queryParam("modelYear"));
        String color = context.queryParam("color");
        List<Car> carList = carService.getCarsByModelYearAndColor(modelYear,color);
        context.json(carList);
    }

    private void getCarBeforeModelYearHandler(@NotNull Context context) {
        int modelYear = Integer.parseInt(context.pathParam("modelYear"));
        List<Car> carList = carService.getCarsBeforeYear(modelYear);
        context.json(carList);
    }

    private void getCarByVINHandler(@NotNull Context context) {
        int vin = Integer.parseInt(context.pathParam("vin"));
        Car car = carService.getCarByVin(vin);
        context.json(car);
    }

    private void postCarHandler(Context context) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Car car = om.readValue(context.body(), Car.class);
        try{
            carService.insertCar(car);
//            201 is the 'resource created' response
            context.status(201);
            context.result("Car added successfully.");
        }catch(CarAlreadyExistsException e){
//            400 is the 'user error' response
            context.status(400);
            context.result("Car with VIN already exists");
        }
    }

    private void postCarCleanStatusHandler(Context context) throws JsonProcessingException {
        int vin = Integer.parseInt(context.queryParam("vin"));
        boolean status = Boolean.parseBoolean(context.queryParam("cleanTitle"));
        try{
            carService.updateTitleStatus(vin, status);
//            201 is the 'resource created' response
            context.status(201);
        }catch(CarDoesNotExistsException e){
//            400 is the 'user error' response
            context.status(400);
            context.result("Car with this VIN does not exists");
        }
    }

    private void deleteCarHandler(Context context) throws JsonProcessingException {
        int vin = Integer.parseInt(context.pathParam("vin"));
        try{
            carService.deleteCarRecord(vin);
//            201 is the 'resource created' response
            context.status(201);
            context.result("Object deleted successfully.");
        }catch(CarDoesNotExistsException e){
//            400 is the 'user error' response
            context.status(400);
            context.result("VIN does not exist.");
        }
    }

    private void getCarByLicenseNumberHandler(@NotNull Context context) {
        int licenseNumber = Integer.parseInt(context.pathParam("licenseNumber"));
        List<Car> carList = carService.getCarsByLicenseNum(licenseNumber);
        context.json(carList);
    }

    private void getCarByAvgPricePerMakeHandler(@NotNull Context context){
        Map<String, Double> carList = carService.getAvgPricePerMake();
        context.json(carList);
    }

    private void getCarCheaperThanHandler(@NotNull Context context) {
        int minPrice = Integer.parseInt(context.pathParam("modelYear"));
        List<Car> carList = carService.getCarsCheaperThan(minPrice);
        context.json(carList);
    }

    private void getCarInRangeOfHandler(Context context)  {
        int minPrice = Integer.parseInt(context.queryParam("minPrice"));
        int maxPrice = Integer.parseInt(context.queryParam("maxPrice"));
        List<Car> carList = carService.getCarsInRange(minPrice, maxPrice);
        if(carList != null)
        {
            context.status(201);
            context.json(carList);
        }
        else{
            context.result("No cars available in that range.");
        }
//            201 is the 'resource created' response

    }

    private void getCarOfMostCommonMake(Context context){
        List<Car> carList = carService.getCarsOfMostCommonMake();
        context.status(201);
        context.json(carList);
    }
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
//Owner API Handlers
//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
    private void postOwnerHandler(Context context) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        Owner owner = om.readValue(context.body(), Owner.class);
        try {
            ownerService.insertOwner(owner);
//                201 is the 'resource created' response
            context.status(201);
            context.result("Owner added successfully.");
        } catch (OwnerAlreadyExistsException e) {
//                400 is the 'user error' response
            context.status(400);
            context.result("Owner with this license number already exists, license number should be unique.");
        }
    }
    private void deleteOwnerHandler(Context context) throws JsonProcessingException {
        int licenseNum = Integer.parseInt(context.pathParam("licenseNum"));
        try{
            ownerService.deleteOwnerRecord(licenseNum);
//            201 is the 'resource created' response
            context.status(201);
            context.result("Object deleted successfully.");
        }catch(OwnerDoesNotExistException e){
//            400 is the 'user error' response
            context.status(400);
            context.result("Owner with this license number does not exist.");
        }
    }

    private void getAllOwnersHandler(Context context){
        context.json(ownerService.getAllOwners());
    }

    private void getOwnerByStateHandler(@NotNull Context context){
        String state = context.pathParam("state");
        List<Owner> ownerList = ownerService.getOwnersByState(state);
        context.json(ownerList);
    }

    private void getOwnersOlderThanAgeHandler(@NotNull Context context) {
        int age = Integer.parseInt(context.pathParam("age"));
        List<Owner> ownerList = ownerService.getOwnersOlderThanAge(age);
        context.json(ownerList);
    }

}
