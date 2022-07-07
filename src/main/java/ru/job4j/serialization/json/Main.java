package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Student student = new Student(false, 30, "Igor", new Faculty("MBA"),
                new String[] {"Business", "Marketing"});

        /* Преобразуем объект student в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(student));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"isStudent\":true,"
                        + "\"age\":35,"
                        + "\"name\":\"Ivan\","
                        + "\"faculty\":"
                        + "{"
                        + "\"name\":\"IT\""
                        + "},"
                        + "\"exam\":"
                        + "[\"Programming\",\"Mathematics\"]"
                        + "}";
        final Student studentMod = gson.fromJson(personJson, Student.class);
        System.out.println(studentMod);
    }
}
