package ru.job4j.map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SimpleMapTest {

    Map<User, Integer> map;
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
        map.put(userOne, 0);
        map.put(userTwo, 1);
        map.put(userThree, 2);
    }


    @Test
    public void whenAddUserAndFound() {
        Assert.assertEquals(Integer.valueOf(0), map.get(userOne));
    }

    @Test
    public void whenAddUserAndNotFound() {
        Assert.assertNull(map.get(new User("Igor", 3, bd)));
    }

    @Test
    public void whenRemoveUserAndReturnTrue() {
        Assert.assertTrue(map.remove(userTwo));
    }

    @Test
    public void whenRemoveUserAndReturnFalse() {
        Assert.assertFalse(map.remove(new User("Igor", 3, bd)));
    }

    @Test
    public void whenIteratorNext() {
        Assert.assertEquals(userOne, map.iterator().next());
    }

    @Test
    public void whenIteratorHasNext() {
        Assert.assertTrue(map.iterator().hasNext());
    }
}
