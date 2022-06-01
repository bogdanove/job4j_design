package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    Set<FileProperty> files = new HashSet<>();

    List<Path> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        file.forEach(f -> {
            if (f.toFile().isFile()) {
                if (!files.add(new FileProperty(f.toFile().length(), f.getFileName().toString()))) {
                    duplicates.add(f.toAbsolutePath());
                }
            }
        });
        duplicates.forEach(System.out::println);
        return super.visitFile(file, attrs);
    }
}