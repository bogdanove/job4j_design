package ru.job4j.ood.lsp.parking;

public class CarParking implements Parking {

    protected final Car[] passengerParking;

    protected final Car[] truckParking;

    private final int passengerPlace;

    private final int truckPlace;

    public CarParking(int passengerPlace, int truckPlace) {
        this.passengerPlace = passengerPlace;
        this.truckPlace = truckPlace;
        this.passengerParking = new Car[passengerPlace];
        this.truckParking = new Car[truckPlace];
    }

    @Override
    public boolean add(Car car) {
        return false;
    }
}
