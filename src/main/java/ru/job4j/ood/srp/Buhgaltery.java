package ru.job4j.ood.srp;

public interface Buhgaltery<T> {
    /*
     *
     * Интерфейс бухгалтерии, методы начисление зарплаты и начисление отпускных,
     * а метод увольнение нарушает принцип SRP,
     * так как относится больше к отделу кадров
     *
     * */

    boolean salaryPay(T t);

    boolean vacationPay(T t);

    T dismissal(T t);
}
