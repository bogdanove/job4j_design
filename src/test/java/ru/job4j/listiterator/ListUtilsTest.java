package ru.job4j.listiterator;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenRemoveLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 0, 1, 2, 2, 2));
        ListUtils.removeIf(input, Predicate.isEqual(2));
        assertThat(input, is(Arrays.asList(0, 1)));
    }

    @Test
    public void whenReplaceLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(2, 0, 1, 2, 2, 2));
        ListUtils.replaceIf(input, Predicate.isEqual(2), 5);
        assertThat(input, is(Arrays.asList(5, 0, 1, 5, 5, 5)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 2, 3, 4, 5, 7, 5, 3));
        List<Integer> elemets = new ArrayList<>(Arrays.asList(0, 3, 5));
        ListUtils.removeAll(input, elemets);
        assertThat(input, is(Arrays.asList(1, 2, 2, 4, 7)));
    }

}
