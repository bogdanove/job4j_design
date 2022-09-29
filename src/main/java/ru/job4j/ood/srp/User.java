package ru.job4j.ood.srp;

import java.util.Objects;

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(address, user.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
