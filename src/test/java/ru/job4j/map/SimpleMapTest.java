package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleMapTest {

    Map<Integer, User> map;
    Calendar bd;
    User userOne;
    User userTwo;
    User userThree;

    @Before
    public void initData() {
        bd = new GregorianCalendar(1985, Calendar.SEPTEMBER, 10);
        map = new SimpleMap<>();
        userOne = new User("Sergey", 0, bd);
        userTwo = new User("Ivan", 1, bd);
        userThree = new User("Evgeniy", 2, bd);
        map.put(0, userOne);
        map.put(1, userTwo);
        map.put(2, userThree);
    }


    @Test
    public void whenAddUserAndFound() {
        Assert.assertEquals(userOne, map.get(0));
    }

    @Test
    public void whenAddUserAndNotFound() {
        Assert.assertNull(map.get(3));
    }

    @Test
    public void whenRemoveUserAndReturnTrue() {
        Assert.assertTrue(map.remove(1));
    }

    @Test
    public void whenRemoveUserAndReturnFalse() {
        Assert.assertFalse(map.remove(3));
    }

    @Test
    public void whenIteratorNext() {
        Assert.assertEquals(Integer.valueOf(0), map.iterator().next());
    }

    @Test
    public void whenIteratorHasNext() {
        Assert.assertTrue(map.iterator().hasNext());
        assertThat(map.iterator().next(), is(0));
    }
}
