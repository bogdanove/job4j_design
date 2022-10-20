package ru.job4j.ood.lsp.parking;

public class PassengerCar extends Car {

    public static final int PASSENGER_SIZE = 1;

    protected PassengerCar(String name) {
        super(name, PASSENGER_SIZE);
    }
}
