package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.food.Bread;
import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.store.Shop;
import ru.job4j.ood.lsp.store.Store;
import ru.job4j.ood.lsp.store.Trash;
import ru.job4j.ood.lsp.store.Warehouse;
import ru.job4j.ood.lsp.util.CalendarExpirationChecker;
import ru.job4j.ood.lsp.util.ExpirationChecker;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ControlQualityTest {

    @Test
    void whenTrashStore() {
        ExpirationChecker<Calendar> checker = new CalendarExpirationChecker();
        Store trash = new Trash(checker);
        Store wh = new Warehouse(checker);
        Store shop = new Shop(checker);
        List<Store> stores = List.of(trash, wh, shop);
        ControlQuality controlQuality = new ControlQuality(stores);
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
        controlQuality.doControl(bread);
        assertThat(trash.getAll().get(0)).isEqualTo(bread);
        assertThat(wh.getAll()).isEmpty();
        assertThat(shop.getAll()).isEmpty();
    }
}