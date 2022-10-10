package ru.job4j.oodtheory.srp;

import java.util.List;

public interface Storage<T> {
    /*
     *
     * Интерфейс хранилища имеет методы получения и сохранения объекта,
     * а так же имеет метод для создания объекта, что нарушает принцип SRP,
     * так как хранилище не должно создавать предметы для хранения
     *
     * */

    List<T> getAll(T t);

    T save(T t);

    T create(String[] args);
}
