package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, max) > 0) {
                max = t;
            }
        }
        return max;
    }
    public <T> T min(List<T> value, Comparator<T> comparator) {
        T min = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, min) < 0) {
                min = t;
            }
        }
        return min;
    }
}
