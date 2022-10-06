package ru.job4j.design.lsp;

import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void doControl(Food food) {
        stores.forEach(store -> store.add(food));
    }
}
