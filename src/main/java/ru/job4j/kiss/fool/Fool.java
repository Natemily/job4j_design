package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    static boolean check3(int value) {
        return value % 3 == 0;
    }
    static boolean check5(int value) {
        return value % 5 == 0;
    }

    public static void computerTurn(int startAt) {
        if (check3(startAt) && check5(startAt)) {
            System.out.println("FizzBuzz");
        } else if (check3(startAt)) {
            System.out.println("Fizz");
        } else if (check5(startAt)) {
            System.out.println("Buzz");
        } else {
            System.out.println(startAt);
        }
    }

    public static boolean userAnswer(String answer, int startAt) {
        String expected;
        boolean res = true;
        if (check3(startAt) && check5(startAt)) {
            expected = "FizzBuzz";
        } else if (check3(startAt)) {
            expected = "Fizz";
        } else if (check5(startAt)) {
            expected = "Buzz";
        } else {
            expected = String.valueOf(startAt);
        }
        if (!expected.equals(answer)) {
            res = false;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            computerTurn(startAt);
            startAt++;
            var answer = input.nextLine();
            if (!userAnswer(answer, startAt)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}