package ru.job4j.gc.prof;

import java.util.*;

public class MainProfiler {

    public static void main(String[] args) {
        List<String> menu = Arrays.asList(
                "1. Создание массива",
                "2. Сортировка пузырьком",
                "3. Сортировка вставками",
                "4. Сортировка слиянием",
                "5. Выход");
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        Data array = null;
        while (true) {
            menu.forEach(System.out::println);
            System.out.print("Select menu: ");
            int answer = in.nextInt();
            if (1 == answer) {
                array = new RandomArray(random);
                array.insert(250000);
                System.out.print("Array created");
            }
            if (2 == answer) {
                Sort bubble = new BubbleSort();
                bubble.sort(array);
                System.out.println("Starting bubble sort");
            }
            if (3 == answer) {
                Sort insert = new InsertSort();
                insert.sort(array);
                System.out.println("Starting insert sort");
            }
            if (4 == answer) {
                Sort merge = new MergeSort();
                merge.sort(array);
                System.out.println("Starting merge sort");
            }
            if (5 == answer) {
                System.out.println("Exit");
                break;
            }
        }
    }
}
