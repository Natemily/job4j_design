package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        String previous = null;
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.startsWith("400") || line.startsWith("500")) {
                    String[] array = line.split(" ");
                    out.print(array[1] + "; ");
                    previous = line;
                } else if ((!line.startsWith("400") && previous != null)
                        || (!line.startsWith("500") && previous != null)) {
                    String[] array = line.split(" ");
                    out.println(array[1] + ";");
                    previous = null;
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