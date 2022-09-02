package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> array = simpleConvert.toList("first", "second", "four", "five");
        assertThat(array).hasSize(4)
                .contains("second", "five")
                .containsExactlyInAnyOrder("second", "five", "first", "four")
                .startsWith("first")
                .endsWith("four", "five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> array = simpleConvert.toSet("first", "second", "four", "five");
        assertThat(array).hasSize(4)
                .containsExactlyInAnyOrder("four", "five", "first", "second")
                .containsAnyOf("one", "five")
                .doesNotContain("one");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> array = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                /*содержит ключи*/
                .containsKeys("three", "four", "five", "first", "second")
                /*содержит значения*/
                .containsValues(2, 0, 3, 1, 4)
                /*не содержит ключ*/
                .doesNotContainKey("zero")
                /*не содержит значение*/
                .doesNotContainValue(5)
                /*содержит пару ключ-значение*/
                .containsEntry("three", 2);
    }
}