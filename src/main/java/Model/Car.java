package Model;

import java.util.Objects;

public class Car {
    private int vin;
    private String model;
    private String make;
    private int modelYear;
    private String color;
    private boolean cleanTitle;

    public Car(int vin, String model, String make, int modelYear, String color, boolean cleanTitle) {
        this.vin = vin;
        this.model = model;
        this.make = make;
        this.modelYear = modelYear;
        this.color = color;
        this.cleanTitle = cleanTitle;
    }
    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCleanTitle() {
        return cleanTitle;
    }

    public void setCleanTitle(boolean cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return vin == car.vin && modelYear == car.modelYear && cleanTitle == car.cleanTitle && Objects.equals(model, car.model) && Objects.equals(make, car.make) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin, model, make, modelYear, color, cleanTitle);
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", modelYear=" + modelYear +
                ", color='" + color + '\'' +
                ", cleanTitle=" + cleanTitle +
                '}'+"/n";
    }
}
