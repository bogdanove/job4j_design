package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String value = values.get(key);
        if (value == null) {
            throw new IllegalArgumentException("wrong argument request");
        }
        return value;
    }

    private void validate(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        for (String x : args) {
            if (!x.contains("=") || !x.startsWith("-") || x.substring(1, x.indexOf("=")).length() == 0 || x.substring(x.indexOf("=") + 1).length() == 0) {
                throw new IllegalArgumentException("wrong argument");
            }
        }
    }

    private void parse(String[] args) throws IllegalArgumentException {
        validate(args);
            for (String line : args) {
                values.put(line.substring(1, line.indexOf("=")), line.substring(line.indexOf("=") + 1));
            }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
