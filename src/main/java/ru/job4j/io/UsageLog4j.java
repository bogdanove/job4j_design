package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        boolean isHimanoid = true;
        double height = 1.74;
        float weight = 68.5F;
        byte count = 1;
        short foot = 42;
        long id = 555588888;
        char sex = 'M';
        LOG.debug("User info name : {}, age : {}, isHimanoid : {}, height : {}, weight : {}, count : {}, foot : {}, id : {}, sex : {}", name, age, isHimanoid, height, weight, count, foot, id, sex);
    }
}