package ru.job4j.serialization.java.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Dog dog = new Dog(true, 8, "Rocket", new Contact("12-345"),
                new String[] {"Playing", "Sleeping"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(dog));

        final String dogJson =
                "{"
                        + "\"active\":true,"
                        + "\"age\":1,"
                        + "\"name\":Jack,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Sleeping\",\"Eating\"]"
                        + "}";
        final Dog dogMod = gson.fromJson(dogJson, Dog.class);
        System.out.println(dogMod);
    }
}
