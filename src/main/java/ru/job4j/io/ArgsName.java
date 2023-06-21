package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("This key: '" + key + "' is missing");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String[] temp = args[i].split("=", 2);
            valid(args[i], temp);
            values.put(temp[0].substring(1), temp[1]);
        }
    }

    private void valid(String arg, String[] temp) {
        if (!arg.contains("=")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain an equal sign");
        }
        if (temp[0].equals("-")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a key");
        }
        if (temp[1].equals("")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not contain a value");
        }
        if (!temp[0].startsWith("-")) {
            throw new IllegalArgumentException("Error: This argument '" + arg + "' does not start with a '-' character");
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}