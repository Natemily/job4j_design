package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void test3() {
        assertThat(Fool.answer(3)).isEqualTo("Fizz");
        assertThat(Fool.answer(6)).isEqualTo("Fizz");
    }

    @Test
    void test5() {
        assertThat(Fool.answer(5)).isEqualTo("Buzz");
        assertThat(Fool.answer(10)).isEqualTo("Buzz");
    }

    @Test
    void test35() {
        assertThat(Fool.answer(15)).isEqualTo("FizzBuzz");
        assertThat(Fool.answer(45)).isEqualTo("FizzBuzz");
    }

    @Test
    void testGeneral() {
        assertThat(Fool.answer(7)).isEqualTo("7");
        assertThat(Fool.answer(8)).isEqualTo("8");
    }
}