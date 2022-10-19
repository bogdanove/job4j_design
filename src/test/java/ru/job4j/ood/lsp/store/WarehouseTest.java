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
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 1, 10, 0);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 50, 10, 0);
        Food milk = new Milk(
                "milk",
                expiryDate,
                createDate,
                100,
                1
        );
        wh.add(milk);
        assertThat(wh.getAll()).contains(milk);
    }

    @Test
    void whenNotAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store wh = new Warehouse(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 1, 10, 0);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 2, 10, 0);
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