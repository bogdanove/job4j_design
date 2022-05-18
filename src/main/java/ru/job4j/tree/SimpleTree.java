package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean isBinary() {
        Predicate<Node<E>> binary = x -> x.children.size() > 2;
        return findByPredicate(binary).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = findBy(parent).isPresent() && findBy(child).isEmpty();
        if (rsl) {
            Node<E> el = new Node<>(child);
            findBy(parent).get().children.add(el);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Predicate<Node<E>> search = x -> x.value.equals(value);
        return findByPredicate(search);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
