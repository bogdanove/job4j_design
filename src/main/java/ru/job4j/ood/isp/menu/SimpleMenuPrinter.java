package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        StringBuilder text = new StringBuilder();
        menu.forEach(item -> {
                    String[] count = item.getNumber().split("\\.");
                    if (count.length > 1) {
                        text.append("  ".repeat(count.length - 1));
                    }
                    text.append(item.getNumber()).append(item.getName()).append(System.lineSeparator());
                }
        );
        System.out.println(text);
    }
}
