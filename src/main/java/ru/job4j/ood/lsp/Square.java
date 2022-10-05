package ru.job4j.ood.lsp;

public class Square extends Rectangle {


    /*
     *
     * Oбъект класса Square — это определенно не объект класса Rectangle.
     * Дело в том, что поведение объекта класса Square не согласовано с поведением объекта класса Rectangle.
     * Ведь квадрат ведет себя иначе, чем прямоугольник.
     * Следовательно Square — не подтип Rectangle, следовательно LSP нарушается.
     *
     * */


    private int width;
    private int height;

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
