package ru.job4j.oodtheory.isp;

public interface Transport {

    /*
     *
     * Нарушение принципа ISP в том что, у автомобиля не будет использоваться метод лететь и плыть,
     * а для самолета плыть, для корабля лететь и ехать, необходимо разделить интерфейс.
     *
     * */

    boolean drive();

    boolean fly();

    boolean addPassenger();

    boolean addCArgo();

    boolean swim();
}
