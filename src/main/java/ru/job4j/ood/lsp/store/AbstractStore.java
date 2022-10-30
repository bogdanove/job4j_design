package ru.job4j.ood.lsp.store;

import ru.job4j.ood.lsp.food.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {

    protected final List<Food> store = new ArrayList<>();

    public boolean add(Food food) {
        return store.add(food);
    }

    public List<Food> getAll() {
        return new ArrayList<>(store);
    }

    public void clean() {
        store.clear();
    }
}
