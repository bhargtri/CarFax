package Controller;

import Model.Car;
import Service.CarService;
import Service.OwnerService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class CarFaxController {
    CarService carService;
    OwnerService ownerService;

    public CarFaxController(CarService carService, OwnerService ownerService)
    {
//        this.carService = carService;
//        this.ownerService = ownerService;
//    }
//
//    public Javalin listAPI()
//    {
//        Javalin app = Javalin.create();
//
//        app.get("car", this::getAllCarsHandler);
//
//
//        return app;
//    }
//
//    private void getAllCarsHandler(Context context){
//        context.json(carService.getAllCars());
//    }
//    private void getCarByMakeHandler(Context context) {
//        String make = context.pathParam("make");
//        Car car = carService.getCarsByMake(make);
//        context.json(p);
    }
}
