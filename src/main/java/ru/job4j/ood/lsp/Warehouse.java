package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse implements Store {

    private final static long STOP = 25;

    private List<Food> store = new ArrayList<>();

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

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(store);
    }
}
