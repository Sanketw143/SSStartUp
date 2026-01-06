package org.ssupstart.API.service;

import org.springframework.stereotype.Service;
import org.ssupstart.API.entity.Car;
import org.ssupstart.API.exception.CarNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class FetchCarDetailService {

    ArrayList<Car> allCars = new ArrayList<>();

    public void addCarsHardcode() {
        allCars.add(new Car(1,"i20", "hyundai"));
        allCars.add(new Car(2,"nexon", "tata"));
        allCars.add(new Car(3,"safari", "maruti"));
    }


    public Car fetchCar(int carId) {
        List<Car> car = allCars.stream().filter(c -> c.getId() == carId).toList();
        if(car.isEmpty()) {
            throw new CarNotFoundException();
        } else
            return car.get(0);
    }
}
