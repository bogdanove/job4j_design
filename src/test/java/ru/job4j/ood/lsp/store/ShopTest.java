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
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 4, 10, 0);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 1, 10, 0);
        Food banana = new Banana(
                "banana",
                expiryDate,
                createDate,
                100,
                1
        );
        shop.add(banana);
        assertThat(shop.getAll().get(0).getPrice()).isEqualTo(70);
    }

    @Test
    void whenNotAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store shop = new Shop(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 4, 10, 0);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) - 1, 10, 0);
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