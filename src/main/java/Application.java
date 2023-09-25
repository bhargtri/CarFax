import DAO.CarDAO;
import Service.CarService;
import Model.Car;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        CarService carService = new CarService(new CarDAO());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose a search criteria:");
            System.out.println("1. Make");
            System.out.println("2. Model");
            System.out.println("3. Color");
            System.out.println("4. Model Year");
            System.out.println("5. Clean Title");
            System.out.println("6. Make and Model");
            System.out.println("7. Model Year and Color");
            System.out.println("8. Cars Before Year");
            System.out.println("9. All Cars");
            System.out.println("10. Vin");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    List<Car> carsByMake = carService.getCarsByMake(make);
                    displayCars(carsByMake);
                }
                case 2 -> {
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    List<Car> carsByModel = carService.getCarsByModel(model);
                    displayCars(carsByModel);
                }
                case 3 -> {
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    List<Car> carsByColor = carService.getCarsByColor(color);
                    displayCars(carsByColor);
                }
                case 4 -> {
                    System.out.print("Enter model year: ");
                    int modelYear = scanner.nextInt();
                    List<Car> carsByModelYear = carService.getCarsByModelYear(modelYear);
                    displayCars(carsByModelYear);
                }
                case 5 -> {
                    List<Car> cleanTitleCars = carService.getCarsIfCleanTitle();
                    displayCars(cleanTitleCars);
                }
                case 6 -> {
                    System.out.print("Enter make: ");
                    String make2 = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model2 = scanner.nextLine();
                    List<Car> carsByMakeAndModel = carService.getCarsByMakeAndModel(make2, model2);
                    displayCars(carsByMakeAndModel);
                }
                case 7 -> {
                    System.out.print("Enter model year: ");
                    int modelYear2 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter color: ");
                    String color2 = scanner.nextLine();
                    List<Car> carsByModelYearAndColor = carService.getCarsByModelYearAndColor(modelYear2, color2);
                    displayCars(carsByModelYearAndColor);
                }
                case 8 -> {
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    List<Car> carsBeforeYear = carService.getCarsBeforeYear(year);
                    displayCars(carsBeforeYear);
                }
                case 9 -> {
                    System.out.print("Enter make: ");
                    String make3 = scanner.nextLine();
                    List<Car> allCars = carService.getAllCars(make3);
                    displayCars(allCars);
                }
                case 10 -> {
                    System.out.print("Enter VIN: ");
                    int vin = scanner.nextInt();
                    Car carByVin = carService.getCarByVin(vin);
                    if (carByVin != null) {
                        System.out.println("Found car with VIN " + vin + ":");
                        displayCarInfo(carByVin);
                    } else {
                        System.out.println("Car not found with VIN " + vin);
                    }
                }
                case 11 -> {
                    System.out.println("Exiting the application.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void displayCars(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars found matching the criteria.");
        } else {
            System.out.println("Found cars:");
            for (Car car : cars) {
                displayCarInfo(car);
            }
        }
    }

    private static void displayCarInfo(Car car) {
        System.out.println("VIN: " + car.getVin());
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Color: " + car.getColor());
        System.out.println("Model Year: " + car.getModelYear());
        System.out.println("Clean Title: " + car.isCleanTitle());
        System.out.println("License Number: " + car.getLicenseNum());
        System.out.println();
    }
}
