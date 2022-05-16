package ru.job4j;

import ru.job4j.map.User;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        Calendar bd = new GregorianCalendar(1985, Calendar.SEPTEMBER, 10);
        User userOne = new User("Evgeniy", 2, bd);
        User userTwo = new User("Evgeniy", 2, bd);
        map.put(userOne, new Object());
        map.put(userTwo, new Object());
        boolean result = userOne.equals(userTwo);
        System.out.println(map);
        System.out.println(result);

    }
}
