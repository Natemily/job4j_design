package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void test3() {
        assertThat(Fool.userAnswer("Fizz", 3)).isTrue();
        assertThat(Fool.userAnswer("3", 3)).isFalse();
        assertThat(Fool.userAnswer("Buzz", 3)).isFalse();
        assertThat(Fool.userAnswer("Fizz", 9)).isTrue();
        assertThat(Fool.userAnswer("FizzBuzz", 6)).isFalse();
        assertThat(Fool.userAnswer("+", 6)).isFalse();
    }

    @Test
    void test5() {
        assertThat(Fool.userAnswer("Buzz", 5)).isTrue();
        assertThat(Fool.userAnswer("5", 5)).isFalse();
        assertThat(Fool.userAnswer("Fizz", 5)).isFalse();
        assertThat(Fool.userAnswer("Buzz", 20)).isTrue();
        assertThat(Fool.userAnswer("FizzBuzz", 25)).isFalse();
        assertThat(Fool.userAnswer("+", 25)).isFalse();
    }

    @Test
    void test35() {
        assertThat(Fool.userAnswer("FizzBuzz", 15)).isTrue();
        assertThat(Fool.userAnswer("15", 15)).isFalse();
        assertThat(Fool.userAnswer("Buzz", 15)).isFalse();
        assertThat(Fool.userAnswer("Fizz", 45)).isFalse();
        assertThat(Fool.userAnswer("FizzBuzz", 15)).isTrue();
        assertThat(Fool.userAnswer("+", 30)).isFalse();
    }

    @Test
    void testGeneral() {
        assertThat(Fool.userAnswer("4", 4)).isTrue();
        assertThat(Fool.userAnswer("15", 15)).isFalse();
        assertThat(Fool.userAnswer("3", 7)).isFalse();
        assertThat(Fool.userAnswer("+", 17)).isFalse();
    }
}