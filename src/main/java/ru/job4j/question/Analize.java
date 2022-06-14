package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int change = 0;
        int del = 0;
        Info info = new Info(0, 0, 0);
        Map<Integer, String> curr = current.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User user : previous) {
            if (curr.containsKey(user.getId()) && !user.getName().equals(curr.get(user.getId()))) {
                info.setChanged(++change);
            } else if (!curr.containsKey(user.getId())) {
                info.setDeleted(++del);
            }
        }
        info.setAdded(current.size() + del - previous.size());
        return info;
    }
}