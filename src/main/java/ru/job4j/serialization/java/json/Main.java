package ru.job4j.serialization.java.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        List<String> list = new ArrayList<>();
        list.add("Eating");
        list.add("Running");
        JSONArray jsonStatuses = new JSONArray(list);

        final Dog dog = new Dog(true, 8, "Rocket", new Contact("12-345"), new String[]{"Playing", "Sleeping"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("active", dog.isActive());
        jsonObject.put("age", dog.getAge());
        jsonObject.put("name", dog.getName());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(dog).toString());
    }
}
