package ru.job4j.ood.lsp;

import java.util.Calendar;

public class ExpiredChecker {

    public long check(Food food) {
        var y = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        var x = food.getExpiryDate().getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        return 100 - (x * 100 / y);
    }
}
