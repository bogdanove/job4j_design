package ru.job4j.ood.ocp;

public class ShopManager {
    /*
     *
     * Нарушает принцип OCP, потому что заложена строгая логика,
     * что бы добавить или убрать товар необходимо изменять код
     *
     * */
    public double sell(String product, double price, double amount) {
        return Math.round((makeDiscount(product) * price * amount));
    }

    public double makeDiscount(String product) {
        double discount;
        switch (product) {
            case "milk":
                discount = 0.9;
            case "potato":
                discount = 0.8;
            case "cheese":
                discount = 0.7;
            default:
                discount = 1;
        }
        return discount;
    }
}
