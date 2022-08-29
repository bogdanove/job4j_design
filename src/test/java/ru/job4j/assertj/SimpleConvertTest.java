package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import ru.job4j.linkedlist.List;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert sc = new SimpleConvert();
        String[] array = sc.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert sc = new SimpleConvert();
        var list = sc.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("three")
                .containsAnyOf("second", "five", "six")
                .startsWith("first")
                .isNotNull();
    }

    @Test
    void checkSet() {
        SimpleConvert sc = new SimpleConvert();
        var set = sc.toSet("1", "1", "2", "3", "4");
        assertThat(set).hasSize(4)
                .endsWith("3", "4")
                .noneMatch(String::isBlank)
                .last().isNotNull().isEqualTo("4");
    }

    @Test
    void checkMap() {
        SimpleConvert sc = new SimpleConvert();
        var map = sc.toMap("q", "w", "e", "r", "t", "y");
        assertThat(map).hasSize(6)
                .doesNotContainKey("99")
                .doesNotContainValue(77)
                .containsEntry("q", 0)
                .containsValue(5);
    }

}