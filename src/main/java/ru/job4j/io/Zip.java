package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                if (file.exists()) {
                    zip.putNextEntry(new ZipEntry(file.getPath()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                        zip.write(out.readAllBytes());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName name = ArgsName.of(args);
        if (!name.get("d").isEmpty() && !name.get("e").isEmpty() && !name.get("o").isEmpty()) {
            File root = new File(name.get("d"));
            List<Path> search = Search.search(root.toPath(), c -> !c.toFile().getName().endsWith(name.get("e")));
            List<File> files = search.stream().map(Path::toFile).collect(Collectors.toList());
            Zip zip = new Zip();
            zip.packFiles(
                    files,
                    new File(name.get("o"))
            );
        }
    }
}
