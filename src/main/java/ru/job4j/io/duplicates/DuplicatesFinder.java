package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), visitor);
        Map<FileProperty, Set<String>> listTotal = visitor.helper();
        for (FileProperty key : listTotal.keySet()) {
            Set<String> value = listTotal.get(key);
            System.out.println(key.toString());
            for (String name : value) {
                System.out.println(name);
            }
        }
    }
}