package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }
    @Test
    public void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("#name"), is(Matchers.nullValue()));
        assertThat(config.value("namename"), is(Matchers.nullValue()));
        assertThat(config.value("key"), is("value=1"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithEmptyKey() {
        String path = "./data/pair_with_empty_key.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithEmptyValue() {
        String path = "./data/pair_with_empty_value.properties";
        Config config = new Config(path);
        config.load();
    }
}
