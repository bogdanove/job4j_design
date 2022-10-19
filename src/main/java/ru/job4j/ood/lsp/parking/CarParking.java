package ru.job4j.ood.lsp.parking;

public class CarParking implements Parking {

    protected final Car[] passengerParking;

    protected final Car[] truckParking;

    public CarParking(Car[] passengerParking, Car[] truckParking) {
        this.passengerParking = passengerParking;
        this.truckParking = truckParking;
    }

    @Override
    public boolean add(Car car) {
        return false;
    }
}
