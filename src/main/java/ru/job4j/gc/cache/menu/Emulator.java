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

    private static final int DIR_CACHE = 1;
    private static final int FILE_NAME_CACHE = 2;
    private static final int GET_CACHE = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirFileCache fileCache = null;
        String fileName = null;
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println("Выберите меню: ");
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (DIR_CACHE == userChoice) {
                System.out.println("Укажите директорию: ");
                String dir = scanner.nextLine();
                fileCache = new DirFileCache(dir);
            } else if (FILE_NAME_CACHE == userChoice) {
                System.out.println("Укажите имя файла: ");
                fileName = scanner.nextLine();
                fileCache.put(fileName, fileName);
            } else if (GET_CACHE == userChoice) {
                System.out.println("Укажите имя файла: ");
                String key = scanner.nextLine();
                System.out.println(fileCache.get(key));
            } else {
                run = false;
            }
        }
    }
}
