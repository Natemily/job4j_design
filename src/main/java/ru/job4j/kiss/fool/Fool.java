package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    static boolean check3(int value) {
        return value % 3 == 0;
    }
    static boolean check5(int value) {
        return value % 5 == 0;
    }

    public static String answer(int startAt) {
        String answer = "";
        if (!check3(startAt) && !check5(startAt)) {
            answer += startAt;
        }
        if (check3(startAt)) {
            answer += "Fizz";
        }
        if (check5(startAt)) {
            answer += "Buzz";
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(answer(startAt));
            startAt++;
            var userAnswer = input.nextLine();
            if (!answer(startAt).equals(userAnswer)) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }
}