package ru.job4j.ood.lsp;

public class DrawShape {

    /*
     *
     * То есть drawShape должна знать обо всех наследниках класса Shape.
     * Более того, каждый раз, когда мы вводим нового наследника класса Shape либо удаляем его,
     * мы должны вносить в неё изменения, следовательно LSP нарушается.
     *
     * */

    public void drawShape(Shape shape) {
        if (shape instanceof Rhombus) {
            drawRhombus((Rhombus) shape);
        } else {
            drawCircle((Circle) shape);
        }
    }

    private void drawRhombus(Rhombus shape) {
    }

    private void drawCircle(Circle shape) {
    }
}
