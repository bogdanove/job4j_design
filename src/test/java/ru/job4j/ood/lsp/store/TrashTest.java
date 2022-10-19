package ru.job4j.ood.lsp.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Bread;
import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.food.Milk;
import ru.job4j.ood.lsp.util.CalendarExpirationChecker;
import ru.job4j.ood.lsp.util.ExpirationChecker;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {

    @Test
    void whenAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store trash = new Trash(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 4, 10, 0);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) - 1, 10, 0);
        Food bread = new Bread(
                "bread",
                expiryDate,
                createDate,
                100,
                1
        );
        trash.add(bread);
        assertThat(trash.getAll()).contains(bread);
    }

    @Test
    void whenNotAdded() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store trash = new Trash(checker);
        Calendar createDate = Calendar.getInstance();
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) - 4, 10, 0);
        Calendar expiryDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR),
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 1, 10, 0);
        Food milk = new Milk(
                "milk",
                expiryDate,
                createDate,
                100,
                1
        );
        trash.add(milk);
        assertThat(trash.getAll()).isEmpty();
    }
}