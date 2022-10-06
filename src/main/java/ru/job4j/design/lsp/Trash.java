package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private final List<Food> store = new ArrayList<>();

    private ExpiredChecker checker;

    public Trash(ExpiredChecker checker) {
        this.checker = checker;
    }

    @Override
    public Food add(Food food) {
        if (checker.check(food) >= 100) {
            store.add(food);
        }
        return food;
    }

    @Override
    public List<Food> getAll() {
        return store;
    }
}
