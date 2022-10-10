package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore {

    protected final List<Food> store = new ArrayList<>();

    public List<Food> getAll() {
        return new ArrayList<>(store);
    }
}
