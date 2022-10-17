package ru.job4j.ood.lsp;

import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.store.Store;

import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void doControl(Food food) {
        stores.forEach(store -> store.add(food));
    }
}
