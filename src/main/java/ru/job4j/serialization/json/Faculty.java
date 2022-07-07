package ru.job4j.serialization.json;

public class Faculty {

    private final String name;

    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Faculty{"
                + "name='" + name + '\''
                + '}';
    }
}
