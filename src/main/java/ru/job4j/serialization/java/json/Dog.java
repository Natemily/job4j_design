package ru.job4j.serialization.java.json;

import java.util.Arrays;

public class Dog {
    private final boolean active;
    private final int age;
    private final String name;
    private final Contact contact;
    private final String[] statuses;

    public Dog(boolean active, int age, String name, Contact contact, String[] statuses) {
        this.active = active;
        this.age = age;
        this.name = name;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Dog{"
                + "active=" + active
                + ", age=" + age
                + ", name=" + name
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}