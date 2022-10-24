package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CarParking implements Parking {
    protected final List<Car> passengerParking;
    protected final List<Car> truckParking;
    private final int passengerPlace;
    private final int truckPlace;

    public CarParking(int passengerPlace, int truckPlace) {
        this.passengerPlace = passengerPlace;
        this.truckPlace = truckPlace;
        this.passengerParking = new ArrayList<>(passengerPlace);
        this.truckParking = new ArrayList<>(truckPlace);
    }

    @Override
    public boolean add(Car car) {
        var result = false;
        if (car.getSize() == PassengerCar.PASSENGER_SIZE && passengerParking.size() < passengerPlace) {
            result = passengerParking.add(car);
        }
        if (car.getSize() > PassengerCar.PASSENGER_SIZE) {
            if (truckParking.size() < truckPlace) {
                result = truckParking.add(car);
            } else if (passengerParking.size() < passengerPlace
                    && car.getSize() <= (passengerPlace - passengerParking.size())) {
                result = passengerParking.add(car);
            }
        }
        return result;
    }
}