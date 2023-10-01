import Controller.CarFaxController;
import DAO.CarDAO;
import DAO.OwnerDAO;
import Service.CarService;
import Service.OwnerService;
import Util.ConnectionSingleton;
import io.javalin.Javalin;

import java.sql.Connection;


public class Application {

    public static void main(String[] args) {
        Connection conn = ConnectionSingleton.getConnection();
        CarDAO carDAO = new CarDAO(conn);
        OwnerDAO ownerDAO = new OwnerDAO(conn);
        CarService carService = new CarService(carDAO);

        OwnerService ownerService = new OwnerService(ownerDAO);
        CarFaxController carFaxController = new CarFaxController(carService, ownerService);
        Javalin server = carFaxController.listAPI();
        server.start();


    }
}
