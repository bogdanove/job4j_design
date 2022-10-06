package ru.job4j.design.lsp;

import java.util.List;

public interface Store {

    Food add(Food food);

    List<Food> getAll();
}
