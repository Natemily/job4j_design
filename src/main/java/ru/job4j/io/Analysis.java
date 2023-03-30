package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> temp = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                temp.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (int i = 0; i < temp.size(); i++) {
                String value = temp.get(i);
                String valueNext = ((i + 1) < temp.size()) ? temp.get(i + 1) : (null);
                if (value.startsWith("400") || value.startsWith("500")) {
                    String[] array = value.split(" ");
                    out.print(array[1] + "; ");
                    if ((valueNext != null && !valueNext.startsWith("400"))
                        || (valueNext != null && !valueNext.startsWith("500"))) {
                    String[] arrayNext = valueNext.split(" ");
                    out.println(arrayNext[1] + ";");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}