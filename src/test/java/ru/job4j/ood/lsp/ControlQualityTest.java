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
        controlQuality.doControl(bread);
        assertThat(trash.getAll()).contains(bread);
        assertThat(wh.getAll()).isEmpty();
        assertThat(shop.getAll()).isEmpty();
    }
}