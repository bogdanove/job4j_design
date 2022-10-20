package ru.job4j.ood.lsp.parking;

public class TruckCar extends Car {

    protected TruckCar(String name, int size) {
        super(name, size);
        if (size <= PassengerCar.PASSENGER_SIZE) {
            throw new IllegalArgumentException("Wrong size for truck!");
        }
    }
}
