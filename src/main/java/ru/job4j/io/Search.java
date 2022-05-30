package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, p -> p.toFile().getName().endsWith(".java")).forEach(System.out::println);
    }
    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        List<Path> list = new ArrayList<>();
        Files.walkFileTree(root, searcher).forEach(e -> {
            if (condition.test(e)) {
                list.add(e);
            }
        });
        return list;
    }
}
