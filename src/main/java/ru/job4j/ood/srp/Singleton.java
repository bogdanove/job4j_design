package ru.job4j.ood.srp;

public class Singleton {
    private static Singleton instance;
    /*
     *
     * Шаблон проектирования Синглтон нарушает принцип SRP,
     * потому что помимо создания объекта, он проверяет наличе таких же экземпляров
     *
     * */
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
