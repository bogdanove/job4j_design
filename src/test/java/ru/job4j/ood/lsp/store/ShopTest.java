package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Banana;
import ru.job4j.ood.lsp.food.Bread;
import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.util.CalendarExpirationChecker;
import ru.job4j.ood.lsp.util.ExpirationChecker;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {

    @Test
    void whenAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store shop = new Shop(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 10);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.OCTOBER, 19);
        Food banana = new Banana(
                "banana",
                expiryDate,
                createDate,
                100,
                1
        );
        shop.add(banana);
        assertThat(shop.getAll().get(0).getDiscount()).isEqualTo(0.7);
    }

    @Test
    void whenNotAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store shop = new Shop(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 10);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.OCTOBER, 3);
        Food bread = new Bread(
                "breed",
                expiryDate,
                createDate,
                100,
                1
        );
        shop.add(bread);
        assertThat(shop.getAll()).isEmpty();
    }
}