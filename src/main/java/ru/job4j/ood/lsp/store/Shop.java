package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.util.ExpirationChecker;
import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.util.FreshnessQuality;

import java.util.Calendar;

public class Shop extends AbstractStore {

    private final ExpirationChecker<Calendar> checker;


    public Shop(ExpirationChecker<Calendar> checker) {
        this.checker = checker;
    }

    @Override
    public boolean add(Food food) {
        boolean result = false;
        var check = checker.getExpirationPercentage(food.getCreateDate(), food.getExpiryDate());
        if (check >= FreshnessQuality.GOOD && check < FreshnessQuality.BAD) {
            if (check > FreshnessQuality.MIDDLE) {
                food.setDiscount(FreshnessQuality.DISCOUNT);
                food.setPrice(food.getPrice() * food.getDiscount());
            }
            result = store.add(food);
        }
        return result;
    }
}
