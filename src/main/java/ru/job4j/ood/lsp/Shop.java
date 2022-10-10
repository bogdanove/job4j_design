package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements Store {

    private final static long START = 25;

    private final static long STOP = 75;

    private final static double DISC = 0.7;

    private List<Food> store = new ArrayList<>();

    private ExpirationChecker<Calendar> checker;


    public Shop(ExpirationChecker checker) {
        this.checker = checker;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        var check = checker.getExpirationPercentage(food.getCreateDate(), food.getExpiryDate());
        if (check >= START && check <= STOP) {
            result = store.add(food);
        }
        if (check > STOP && check < 100) {
            food.setDiscount(DISC);
            result = store.add(food);
        }
        return result;
    }

    @Override
    public List<Food> getAll() {
        return new ArrayList<>(store);
    }
}
