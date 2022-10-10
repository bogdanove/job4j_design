package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenTrashStore() {
        ExpirationChecker checker = new CalendarExpirationChecker();
        Store trash = new Trash(checker);
        ControlQuality controlQuality = new ControlQuality(List.of(trash, new Shop(checker), new Warehouse(checker)));
        var createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 10);
        var expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.OCTOBER, 3);
        Food bread = new Bread(
                "bread",
                expiryDate,
                createDate,
                100,
                1
        );
        controlQuality.doControl(bread);
        assertThat(trash.getAll().get(0)).isEqualTo(bread);
    }

    @Test
    void whenWarehouseStore() {
        ExpirationChecker checker = new CalendarExpirationChecker();
        Store wh = new Warehouse(checker);
        ControlQuality controlQuality = new ControlQuality(List.of(wh, new Shop(checker), new Trash(checker)));
        var createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 19);
        var expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.DECEMBER, 31);
        Food banana = new Banana(
                "banana",
                expiryDate,
                createDate,
                100,
                1
        );
        controlQuality.doControl(banana);
        assertThat(wh.getAll().get(0)).isEqualTo(banana);
    }

    @Test
    void whenShopStore() {
        ExpirationChecker checker = new CalendarExpirationChecker();
        Store shop = new Shop(checker);
        ControlQuality controlQuality = new ControlQuality(List.of(shop, new Trash(checker), new Warehouse(checker)));
        var createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 10);
        var expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.OCTOBER, 30);
        Food milk = new Milk(
                "milk",
                expiryDate,
                createDate,
                100,
                1
        );
        controlQuality.doControl(milk);
        assertThat(shop.getAll().get(0)).isEqualTo(milk);
    }

    @Test
    void whenShopStoreAndSetDiscount() {
        ExpirationChecker checker = new CalendarExpirationChecker();
        Store shop = new Shop(checker);
        ControlQuality controlQuality = new ControlQuality(List.of(shop, new Trash(checker), new Warehouse(checker)));
        var createDate = Calendar.getInstance();
        createDate.set(2022, Calendar.SEPTEMBER, 10);
        var expiryDate = Calendar.getInstance();
        expiryDate.set(2022, Calendar.OCTOBER, 13);
        Food milk = new Milk(
                "milk",
                expiryDate,
                createDate,
                100,
                1
        );
        controlQuality.doControl(milk);
        assertThat(shop.getAll().get(0).getDiscount()).isEqualTo(0.7);
    }
}