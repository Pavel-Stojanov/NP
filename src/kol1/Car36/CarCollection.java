package kol1.Car36;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    List<Car> cars;

    public CarCollection() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void sortByPrice(boolean ascending) {
        if (ascending) {
            cars = cars.stream().sorted().collect(Collectors.toList());
        } else {
            cars = cars.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Car> filterByManufacturer(String manufacturer) {
        return cars.stream().filter(car -> manufacturer.equalsIgnoreCase(car.getManufacturer())).sorted(Comparator.comparing(Car::getModel)).collect(Collectors.toList());
    }

    public List<Car> getList() {
        return cars;
    }


}
