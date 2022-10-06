package ru.job4j.design.lsp;

import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
