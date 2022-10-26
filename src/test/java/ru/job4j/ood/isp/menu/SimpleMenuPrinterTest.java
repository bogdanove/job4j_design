package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class SimpleMenuPrinterTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    protected final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void whenMenuPrint() {
        Menu menu = new SimpleMenu();
        MenuPrinter printer = new SimpleMenuPrinter();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        StringBuilder text = new StringBuilder();
        text.append("1.Сходить в магазин").append(System.lineSeparator())
                .append("  ").append("1.1.Купить продукты").append(System.lineSeparator())
                .append(System.lineSeparator());
        printer.print(menu);
        assertThat(text.toString())
                .isEqualTo(output.toString());
    }
}