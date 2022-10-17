package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Bread;
import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.food.Milk;
import ru.job4j.ood.lsp.util.CalendarExpirationChecker;
import ru.job4j.ood.lsp.util.ExpirationChecker;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class WarehouseTest {

    @Test
    void whenAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store wh = new Warehouse(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 25);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.DECEMBER, 31);
        Food milk = new Milk(
                "milk",
                expiryDate,
                createDate,
                100,
                1
        );
        wh.add(milk);
        assertThat(wh.getAll().get(0)).isEqualTo(milk);
    }

    @Test
    void whenNotAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store wh = new Warehouse(checker);
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
        wh.add(bread);
        assertThat(wh.getAll()).isEmpty();
    }
}