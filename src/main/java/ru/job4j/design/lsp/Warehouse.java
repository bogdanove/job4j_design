package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private final static long STOP = 25;

    private List<Food> store = new ArrayList<>();

    private ExpiredChecker checker;


    public Warehouse(ExpiredChecker checker) {
        this.checker = checker;
    }

    @Override
    public Food add(Food food) {
        if (checker.check(food) < STOP) {
            store.add(food);
        }
        return food;
    }

    @Override
    public List<Food> getAll() {
        return store;
    }
}
