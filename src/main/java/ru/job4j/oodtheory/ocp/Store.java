package ru.job4j.oodtheory.ocp;

import java.util.ArrayList;
import java.util.List;

public class Store {

    /*
     *
     *Нарушение принципа OCP заключается в том, что мы используем классы напрямую, без абстракций
     *
     * */

    private Print printer;
    private List<String> storage = new ArrayList<>();

    public Store() {
        printer = new Print();
    }

    public String add(String text) {
        storage.add(text);
        printer.print(text);
        return text;
    }

    public class Print {
        public void print(String text) {
            System.out.println(text);
        }
    }
}