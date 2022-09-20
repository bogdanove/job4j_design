package ru.job4j.gc.cache;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String content = null;
        try {
            content = Files.readString(Paths.get(String.format("%s%s", cachingDir, key)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}
