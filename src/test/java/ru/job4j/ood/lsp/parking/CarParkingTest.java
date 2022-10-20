package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
class CarParkingTest {

    @Test
    void whenAddTwoPassengerAndOneTruck() {
        CarParking parking = new CarParking(2, 1);
        Car kia = new PassengerCar("rio");
        Car vaz = new PassengerCar("granta");
        Car kamaz = new TruckCar("Kamaz", 2);
        assertThat(parking.add(kia)).isTrue();
        assertThat(parking.add(vaz)).isTrue();
        assertThat(parking.add(kamaz)).isTrue();
    }

    @Test
    void whenAddTwoTruck() {
        CarParking parking = new CarParking(2, 1);
        Car kamaz = new TruckCar("Kamaz", 2);
        Car renault = new TruckCar("Renault", 2);
        assertThat(parking.add(kamaz)).isTrue();
        assertThat(parking.add(renault)).isTrue();
    }

    @Test
    void whenAddThreePassengerCar() {
        CarParking parking = new CarParking(2, 1);
        Car kia = new PassengerCar("rio");
        Car vaz = new PassengerCar("granta");
        Car volvo = new PassengerCar("volvo");
        assertThat(parking.add(kia)).isTrue();
        assertThat(parking.add(vaz)).isTrue();
        assertThat(parking.add(volvo)).isFalse();
    }

    @Test
    void whenAddThreeTruck() {
        CarParking parking = new CarParking(2, 1);
        Car kamaz = new TruckCar("Kamaz", 2);
        Car renault = new TruckCar("Renault", 3);
        assertThat(parking.add(kamaz)).isTrue();
        assertThat(parking.add(renault)).isFalse();
    }
}