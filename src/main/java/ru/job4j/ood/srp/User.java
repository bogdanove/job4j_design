package ru.job4j.ood.srp;

public class User {

    /*
     *
     * Этот класс нарушает принцип SRP потому что в нем реализуется дополнительная логика.
     *
     */

    private String name;
    private String address;
    public boolean isHumanioid() {
        return name.isEmpty() && address.isEmpty();
    }
}
