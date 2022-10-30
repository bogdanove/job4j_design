package ru.job4j.ood.lsp;

import ru.job4j.ood.lsp.food.Food;
import ru.job4j.ood.lsp.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void doControl(Food food) {
        stores.forEach(store -> store.add(food));
    }

    public void resort() {
       List<Food> resortList = new ArrayList<>();
       stores.forEach(store -> resortList.addAll(store.getAll()));
       stores.forEach(Store::clean);
       resortList.forEach(this::doControl);
    }
}
