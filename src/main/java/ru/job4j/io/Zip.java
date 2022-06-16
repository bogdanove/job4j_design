package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                if (path.toFile().exists()) {
                    zip.putNextEntry(new ZipEntry(path.toString()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(path.toString()))) {
                        zip.write(out.readAllBytes());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName name = validateArgs(args);
        File root = new File(name.get("d"));
        List<Path> search = Search.search(root.toPath(), c -> !c.toFile().getName().endsWith(name.get("e")));
        Zip zip = new Zip();
        zip.packFiles(
                search,
                new File(name.get("o"))
        );
    }

    private static ArgsName validateArgs(String[] args) {
        ArgsName name = ArgsName.of(args);
        if (args.length != 3 && !name.get("d").startsWith(".") && !name.get("e").startsWith(".") && name.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException();
        }
        return name;
    }
}