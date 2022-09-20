package ru.job4j.gc.cache;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(load(key)));
    }

    public V get(K key) {
        var result = cache.get(key).get();
        return result != null ? result : load(key);
    }

    protected abstract V load(K key);

}
