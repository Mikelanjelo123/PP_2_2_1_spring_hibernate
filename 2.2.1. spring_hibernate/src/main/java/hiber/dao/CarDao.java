package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface CarDao {
    void add(Car car);

    List<Car> ListCars();

    String fetchUserByCarModelAndSeries(int serial, String model);
}
