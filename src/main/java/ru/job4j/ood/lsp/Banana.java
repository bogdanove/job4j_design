package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Banana extends Food {

    public Banana(String name, Calendar expiryDate, Calendar createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
