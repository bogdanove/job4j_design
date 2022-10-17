package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.util.ExpirationChecker;
import ru.job4j.ood.lsp.food.Food;

import java.util.Calendar;

public class Shop extends AbstractStore {

    private final static long START = 25;

    private final static long STOP = 75;

    private final static double DISC = 0.7;

    private final ExpirationChecker<Calendar> checker;


    public Shop(ExpirationChecker<Calendar> checker) {
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
}
