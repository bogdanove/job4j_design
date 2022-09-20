package ru.job4j.gc.cache.menu;

import ru.job4j.gc.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {

    private static final String MENU = """
                Введите 1, указать кэшируемую директорию.
                Введите 2, загрузить содержимое файла в кэш.
                Введите 3, получить содержимое файла из кэша.
                Введите любое другое число для выхода.
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirFileCache fileCache = null;
        String fileName = null;
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println("Выберите меню: ");
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (1 == userChoice) {
                System.out.println("Укажите директорию: ");
                String dir = scanner.nextLine();
                fileCache = new DirFileCache(dir);
            } else if (2 == userChoice) {
                System.out.println("Укажите имя файла: ");
                fileName = scanner.nextLine();
                fileCache.put(fileName, fileName);
            } else if (3 == userChoice) {
                System.out.println("Укажите имя файла: ");
                String key = scanner.nextLine();
                System.out.println(fileCache.get(key));
            } else {
                run = false;
            }
        }
    }
}
