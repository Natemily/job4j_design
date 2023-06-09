package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, Set<String>> filesList = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
            filesList.computeIfAbsent(fileProperty, k -> new HashSet<>()).add(file.toAbsolutePath().toString());
        }
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, Set<String>> helper() {
        Map<FileProperty, Set<String>> filesListTotal = new HashMap<>();
        for (FileProperty key : filesList.keySet()) {
            if (filesList.get(key).size() > 1) {
                filesListTotal.put(key, filesList.get(key));
            }
        }
        return filesListTotal;
    }

    public void print(Map<FileProperty, Set<String>> list) {
        for (FileProperty key : list.keySet()) {
            Set<String> value = list.get(key);
            System.out.println(key.toString());
            for (String name : value) {
                System.out.println(name);
            }
        }
    }
}