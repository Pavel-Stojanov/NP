package kol1.Car36;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String manufacturer;
    private String model;
    private int price;
    private float power;


    public Car(String manufacturer, String model, int price, float power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public float getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%.0fKW) %d", manufacturer, model, power, price);
    }

    @Override
    public int compareTo(Car o) {
        return Comparator.comparing(Car::getPrice).thenComparing(Car::getPower).compare(this, o);
    }
}
