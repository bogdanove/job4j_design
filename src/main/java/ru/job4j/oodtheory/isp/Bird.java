package ru.job4j.oodtheory.isp;

public interface Bird {

    /*
     *
     * Нарушение принципа ISP в том, что не все птицы могут летать или плавать,
     * поэтому не все птицы будут использовать все методы.
     *
     * */

    boolean fly();

    boolean run();

    boolean swim();
}
