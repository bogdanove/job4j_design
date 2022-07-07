package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

        /* JSONObject из json-строки строки */
        JSONObject jsonFaculty = new JSONObject("{\"name\":\"MBA\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Business");
        list.add("Marketing");
        JSONArray jsonExams = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Student stud = new Student(false, 30, "Igor", new Faculty("MBA"), new String[]{"Programming", "Mathematics"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isStudent", stud.isStudent());
        jsonObject.put("age", stud.getAge());
        jsonObject.put("name", stud.getName());
        jsonObject.put("faculty", jsonFaculty);
        jsonObject.put("exam", jsonExams);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(stud).toString());
    }
}
