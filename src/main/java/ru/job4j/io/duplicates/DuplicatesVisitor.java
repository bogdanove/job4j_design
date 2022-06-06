package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty search = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (files.containsKey(search)) {
            files.get(search).add(file.toAbsolutePath());
        } else {
            files.put((search), new ArrayList<>(Arrays.asList(file.toAbsolutePath())));
        }
        return super.visitFile(file, attrs);
    }

    public void getFiles() {
        files.values().stream().filter(x -> x.size() > 1).forEach(list -> list.forEach(System.out::println));
    }
}