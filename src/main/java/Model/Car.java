package Model;

import lombok.Data;

import java.util.Objects;

@Data
public class Car {
    private int vin;
    private String model;
    private String make;
    private int modelYear;
    private String color;
    private boolean cleanTitle;
    private int licenseNum;
    private double price;

    public Car() {
    }

    public Car(int vin, String model, String make, int modelYear, String color, boolean cleanTitle, int licenseNum, double price) {
        this.vin = vin;
        this.model = model;
        this.make = make;
        this.modelYear = modelYear;
        this.color = color;
        this.cleanTitle = cleanTitle;
        this.licenseNum = licenseNum;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return vin == car.vin && modelYear == car.modelYear && cleanTitle == car.cleanTitle && Objects.equals(model, car.model) && Objects.equals(make, car.make) && Objects.equals(color, car.color) && this.licenseNum == car.licenseNum && this.price == car.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, model, make, modelYear, color, cleanTitle, licenseNum, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", modelYear=" + modelYear + '\'' +
                ", color='" + color + '\'' +
                ", cleanTitle=" + cleanTitle + '\'' +
                ", licenseNum=" + licenseNum + '\'' +
                ", price=" + price +
                '}'+"/n";
    }
}
