package ru.job4j.linkedlist;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    private int sizein;
    private int sizeout;

    public T poll() {
        if (sizein == 0 && sizeout == 0) {
            throw new NoSuchElementException();
        }
        if (sizeout == 0) {
            while (sizein > 0) {
                out.push(in.pop());
                sizein--;
                sizeout++;
            }
        }
        T t = out.pop();
        sizeout--;
        return t;
    }

    public void push(T value) {
        in.push(value);
        sizein++;
    }
}
