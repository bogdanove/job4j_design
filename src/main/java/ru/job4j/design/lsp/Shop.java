package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private final static long START = 25;

    private final static long STOP = 75;

    private final static double DISC = 0.7;

    private List<Food> store = new ArrayList<>();

    private ExpiredChecker checker;


    public Shop(ExpiredChecker checker) {
        this.checker = checker;
    }

    @Override
    public Food add(Food food) {
        var check = checker.check(food);
        if (check >= START && check <= STOP) {
            store.add(food);
        }
        if (check > STOP && check < 100) {
            food.setDiscount(DISC);
            store.add(food);
        }
        return food;
    }

    @Override
    public List<Food> getAll() {
        return store;
    }
}
