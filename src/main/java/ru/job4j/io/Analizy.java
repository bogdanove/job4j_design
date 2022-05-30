package ru.job4j.io;

import java.io.*;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Analizy {

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            StringJoiner info = new StringJoiner(";", "SERVER DOWN INFO", ";");
            AtomicBoolean status = new AtomicBoolean(true);
            read.lines().forEach(line -> {
                        if ((line.substring(0, line.indexOf(" ")).equals("500") || line.substring(0, line.indexOf(" ")).equals("400")) && status.get()) {
                            status.set(false);
                            info.add(System.lineSeparator() + line.substring(line.indexOf(" ") + 1));
                        }
                        if (!status.get() && (line.substring(0, line.indexOf(" ")).equals("200") || line.substring(0, line.indexOf(" ")).equals("300"))) {
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
