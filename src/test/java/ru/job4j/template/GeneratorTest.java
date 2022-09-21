package ru.job4j.template;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Ignore
@Disabled
class GeneratorTest {
    @Test
    public void whenGenerate() {
        Generator gen = new SimpleGenerator();
        var template = "I am a ${name}, Who are ${subject}?";
        var args = new HashMap<String, String>();
        args.put("name", "Ivan Ivanov");
        args.put("subject", "you");
        assertThat(gen.produce(template, args)).isEqualTo("I am a Ivan Ivanov, Who are you?");
    }
    @Test
    public void whenKeyNotFound() {
        Generator gen = new SimpleGenerator();
        var template = "I am a ${name}, Who are ${subject}? ";
        var args = new HashMap<String, String>();
        args.put("name", "Ivan Ivanov");
        assertThrows(IllegalArgumentException.class, () -> {
            gen.produce(template, args);
        });
    }
    @Test
    public void whenExtraKey() {
        Generator gen = new SimpleGenerator();
        var template = "I am a ${name}, Who are ${subject}? ";
        var args = new HashMap<String, String>();
        args.put("name", "Ivan Ivanov");
        args.put("subject", "you");
        args.put("error", "they");
        assertThrows(IllegalArgumentException.class, () -> {
            gen.produce(template, args);
        });
    }
}