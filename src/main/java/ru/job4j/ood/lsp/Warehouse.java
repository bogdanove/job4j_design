package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Warehouse extends AbstractStore {

    private final static long STOP = 25;

    private ExpirationChecker<Calendar> checker;


    public Warehouse(ExpirationChecker checker) {
        this.checker = checker;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (checker.getExpirationPercentage(food.getCreateDate(), food.getExpiryDate()) < STOP) {
            result = store.add(food);
        }
        return result;
    }
}
