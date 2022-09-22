package ru.job4j.kiss;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MaxMinTest {
    @Test
    public void testMax() {
        List<Integer> list = Arrays.asList(0, 6, 22, 2, 3);
        MaxMin max = new MaxMin();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        assertThat(max.max(list, comp)).isEqualTo(22);
    }
    @Test
    public void testMin() {
        List<Integer> list = Arrays.asList(11, 2, 0, 6, 22);
        MaxMin max = new MaxMin();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        assertThat(max.min(list, comp)).isEqualTo(0);
    }

    @Test
    public void testWhenListIsEmpty() {
        List<Integer> list = new ArrayList<>();
        MaxMin max = new MaxMin();
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        assertThat(max.min(list, comp)).isNull();
    }
}