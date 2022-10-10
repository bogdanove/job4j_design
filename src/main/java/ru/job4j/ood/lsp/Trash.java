package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trash implements Store {

    private final List<Food> store = new ArrayList<>();

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

    @Override
    public List<Food> getAll() {
        return store;
    }
}
