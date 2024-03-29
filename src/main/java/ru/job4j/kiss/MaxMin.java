package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return comparing(value, comparator);
    }
    public <T> T min(List<T> value, Comparator<T> comparator) {
        return comparing(value, comparator.reversed());
    }

    private <T> T comparing(List<T> value, Comparator<T> comparator) {
        if (value.isEmpty()) {
            return null;
        }
        T temp = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, temp) > 0) {
                temp = t;
            }
        }
        return temp;
    }
}
