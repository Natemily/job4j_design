package ru.job4j.map.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        birthday.set(2011, 6, 1);
        User user1 = new User("Vanessa", 2, birthday);
        User user2 = new User("Vanessa", 2, birthday);

        Map<User, Object> map = new HashMap<>(2);
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (Map.Entry<User, Object> entry : map.entrySet()) {
            User key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
