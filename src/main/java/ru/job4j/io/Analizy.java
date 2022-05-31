package ru.job4j.io;

import java.io.*;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Analizy {

    public static void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            StringJoiner info = new StringJoiner(";", "SERVER DOWN INFO:", ";");
            AtomicBoolean status = new AtomicBoolean(true);
            read.lines().forEach(line -> {
                        if (("500".equals(line.substring(0, line.indexOf(" "))) || "400".equals(line.substring(0, line.indexOf(" ")))) && status.get()) {
                            status.set(false);
                            info.add(System.lineSeparator() + line.substring(line.indexOf(" ") + 1));
                        }
                        if (!status.get() && ("200".equals(line.substring(0, line.indexOf(" "))) || "300".equals(line.substring(0, line.indexOf(" "))))) {
                            info.add(line.substring(line.indexOf(" ") + 1));
                            status.set(true);
                        }
                    }
            );
            out.print(info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
