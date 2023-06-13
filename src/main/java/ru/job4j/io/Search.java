package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        valid(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static void valid(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Должно быть два аргумента.");
        }
        if (!Files.exists(Paths.get(args[0]))) {
            throw new IllegalArgumentException("Папка должна существовать. Проверьте ее наличие.");
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException("Раcширение файлов должно начинаться с точки");
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}