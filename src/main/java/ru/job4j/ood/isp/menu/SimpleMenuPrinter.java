package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {

    public static final String TAB = "  ";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo item : menu) {
            int count = item.getNumber().split("\\.").length - 1;
            System.out.println(TAB.repeat(count)
                    + item.getNumber()
                    + item.getName());
        }
    }
}
