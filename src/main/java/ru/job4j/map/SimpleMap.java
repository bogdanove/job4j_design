package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        MapEntry<K, V> map = new MapEntry<>(key, value);
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        if (count == table.length * LOAD_FACTOR) {
            expand();
            modCount++;
        }
        if (get(key) == null) {
            table[index] = map;
            result = true;
            count++;
            modCount++;
        }
        return result;
    }

    private int hash(int hashCode) {
        return (hashCode) ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        Arrays.copyOf(table, table.length * 2);
    }

    private MapEntry<K, V> find(K key) {
        int index = -1;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && key.equals(table[i].key)) {
                index = i;
            }
        }
        return index != -1 ? table[index] : null;
    }

    @Override
    public V get(K key) {
        return find(key) != null ? find(key).value : null;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        if (find(key) != null) {
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null && key.equals(table[i].key)) {
                    table[i] = null;
                }
            }
            result = true;
            count--;
            modCount++;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int expectedModCount = modCount;
            private int index;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return index < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
