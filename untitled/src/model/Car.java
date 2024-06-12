package model;

import java.util.Objects;

public class Car {
    private String make;
    private int year;
    private Double engineSize;

    public Car(String make, int year, Double engineSize) {
        this.make = make;
        this.year = year;
        this.engineSize = engineSize;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Double engineSize) {
        this.engineSize = engineSize;
    }

    //Commenting code => Ctrl + /
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(make, car.make) && Objects.equals(engineSize, car.engineSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, year, engineSize);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", engineSize=" + engineSize +
                '}';
    }
}
