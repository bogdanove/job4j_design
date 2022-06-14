package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean flag = true;
        boolean paused = false;
        Scanner in = new Scanner(System.in);
        String line;
        List<String> log = new ArrayList();
        Random random = new Random();
        while (flag) {
            System.out.print("Input a question: ");
            line = in.nextLine();
            String answer = readPhrases().get(random.nextInt(readPhrases().size()));
            log.add(line);
            if (line.equals(STOP)) {
                System.out.println("Paused");
                paused = true;
            }
            if (line.equals(CONTINUE)) {
                paused = false;
                System.out.println("Let's go!");
                run();
            }
            saveLog(log);
            if (line.equals(OUT)) {
                flag = false;
                System.out.println("OFF");
            }
            if (!paused && flag) {
                log.add(answer);
                System.out.println(answer);
            }
        }
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("UTF-8")))) {
            phrases = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt", "./src/data/text.txt");
        cc.run();
    }
}
