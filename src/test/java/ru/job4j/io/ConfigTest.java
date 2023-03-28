package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithEmptyLine() {
        String path = "./data/pair_with_empty_line.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithMoreEquals() {
        String path = "./data/pair_with_more_equals.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr= =Arsentev=");
    }

    @Test
    void whenPairExceptionWithoutKey() {
        String path = "./data/pair_exception_without_key.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> config.load());
    }

    @Test
    void whenPairExceptionWithoutValue() {
        String path = "./data/pair_exception_without_value.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> config.load());
    }

    @Test
    void whenPairExceptionWithoutKeyAndValue() {
        String path = "./data/pair_exception_without_key_and_value.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> config.load());
    }

    @Test
    void whenPairExceptionWithoutEquals() {
        String path = "./data/pair_exception_without_equals.properties";
        Config config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> config.load());
    }
}