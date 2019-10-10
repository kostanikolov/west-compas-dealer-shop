package app.service;

import app.domain.models.service.CarServiceModel;

import java.util.List;

public interface CarService {

    void createCar(CarServiceModel car);

    List<CarServiceModel> allCars();
}
