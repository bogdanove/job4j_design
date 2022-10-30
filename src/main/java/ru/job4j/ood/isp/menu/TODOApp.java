package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    private static final int ROOT = 1;
    private static final int CHILD = 2;
    private static final int PRINT = 3;
    private static final int EXIT = 4;
    private static final String DESCRIPTION = """
            Что бы добавть корневую задачу - введите: 1
            Что бы добавить подзадачу - введите: 2
            Что бы вывести список задач - введите: 3
            Для завершения работы - введите: 4
            """;

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new SimpleMenuPrinter();
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        String taskName;
        String parent = null;
        while (flag) {
            System.out.println(DESCRIPTION);
            System.out.print("Выберите пункт меню: ");
            int userChoice = Integer.parseInt(in.nextLine());
            if (ROOT == userChoice) {
                System.out.print("Введите задачу: ");
                taskName = in.nextLine();
                menu.add(parent, taskName, STUB_ACTION);
            }
            if (CHILD == userChoice) {
                System.out.print("Введите кореневую задачу: ");
                parent = in.nextLine();
                System.out.print("Введите подзадачу: ");
                taskName = in.nextLine();
                menu.add(parent, taskName, STUB_ACTION);
                parent = null;
            }
            if (PRINT == userChoice) {
                printer.print(menu);
            }
            if (EXIT == userChoice) {
                flag = false;
            }
        }
    }
}
