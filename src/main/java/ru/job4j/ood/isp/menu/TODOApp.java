package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    private static final String PRINT = "печать";

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new SimpleMenuPrinter();
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        String taskName;
        String parent = null;
        System.out.println("Что бы добавть корневую задачу, просто введите ее");
        System.out.println("Что бы добавить подзадачу, сначала введите название корневой задачи");
        System.out.println("Что бы вывести список задач - введите: печать");
        while (flag) {
            if (parent == null) {
                System.out.print("Введите задачу: ");
            } else {
                System.out.print("Введите подзадачу: ");
            }
            taskName = in.nextLine();
            if (PRINT.equals(taskName)) {
                flag = false;
                printer.print(menu);
            }
            var current = menu.select(taskName);
            if (current.isEmpty() && parent == null) {
                menu.add(parent, taskName, STUB_ACTION);
            }
            if (current.isPresent()) {
                parent = current.get().getName();
                System.out.printf("Введена корневая задача: %s%n", parent);
            }
            if (current.isEmpty() && parent != null) {
                menu.add(parent, taskName, STUB_ACTION);
                parent = null;
            }
        }
    }
}
