package org.example;

public class Car {
    private String make;
    private int productionYear;
    private double engineSize;

    public Car(){

    }
    public Car(String make, int productionYear, double engineSize) {
        this.make = make;
        this.productionYear = productionYear;
        this.engineSize = engineSize;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", productionYear=" + productionYear +
                ", engineSize=" + engineSize +
                '}';
    }
}
