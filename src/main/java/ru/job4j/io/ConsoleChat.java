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
    private static final String PAUSED_ON = "Paused";
    private static final String PAUSED_OFF = "Let's go!";
    private static final String SWITCH_OFF = "OFF";
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
            if (STOP.equals(line)) {
                log.add(PAUSED_ON);
                System.out.println(PAUSED_ON);
                paused = true;
            }
            if (CONTINUE.equals(line)) {
                paused = false;
                log.add(PAUSED_OFF);
                System.out.println(PAUSED_OFF);
            }
            if (OUT.equals(line)) {
                flag = false;
                log.add(SWITCH_OFF);
                System.out.println(SWITCH_OFF);
            }
            if (!paused && flag) {
                log.add(answer);
                System.out.println(answer);
            }
            saveLog(log);
        }
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
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
