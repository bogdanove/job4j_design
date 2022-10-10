package ru.job4j.oodtheory.srp;

public interface Shop<T> {
    /*
     *
     * Интерфейс магазина, методы покупки и продажи,
     * а метод печать - нарушает принципы SRP,
     * так как печать не относится к работе магазина
     *
     * */

    boolean buy(T t);

    T sell(T t);

    void print(T t);
}
