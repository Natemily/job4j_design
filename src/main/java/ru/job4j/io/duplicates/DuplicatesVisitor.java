package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    HashMap<FileProperty, Set<String>> filesList = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (attrs.isRegularFile()) {
            FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
            filesList.computeIfAbsent(fileProperty, k -> new HashSet<>()).add(file.toAbsolutePath().toString());
        }


        System.out.println(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }
}