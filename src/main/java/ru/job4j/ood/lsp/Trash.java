package ru.job4j.ood.lsp;

import java.util.Calendar;

public class Trash extends AbstractStore {

    private ExpirationChecker<Calendar> checker;

    public Trash(ExpirationChecker checker) {
        this.checker = checker;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (checker.getExpirationPercentage(food.getCreateDate(), food.getExpiryDate()) >= 100) {
            result = store.add(food);
        }
        return result;
    }
}
