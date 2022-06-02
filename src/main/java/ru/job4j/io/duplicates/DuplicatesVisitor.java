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
        if (!files.add(new FileProperty(file.toFile().length(), file.toFile().getName()))) {
            duplicates.add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        return duplicates;
    }
}