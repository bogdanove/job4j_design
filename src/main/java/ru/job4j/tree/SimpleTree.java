package ru.job4j.tree;

import java.util.*;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = findBy(parent).isPresent() && findBy(child).isEmpty();
        if (rsl) {
            Node<E> el = new Node<>(child);
            if (!root.value.equals(parent)) {
                routeTree(root, parent, el);
            } else {
                root.children.add(el);
            }
        }
        return rsl;
    }
    private void routeTree(Node<E> startNode, E key, Node<E> el) {
        for (Node<E> node : startNode.children) {
            if (node.value.equals(key)) {
                node.children.add(el);
                break;
            }
            routeTree(node, key, el);
        }
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}
