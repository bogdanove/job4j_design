package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.util.ExpirationChecker;
import ru.job4j.ood.lsp.food.Food;

import java.util.Calendar;

public class Trash extends AbstractStore {

    private final ExpirationChecker<Calendar> checker;

    public Trash(ExpirationChecker<Calendar> checker) {
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
