package me.hsgamer.edublock.rs.test;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class Report {
    private static final List<String> lines;

    static {
        lines = new ArrayList<>();
    }

    public static void addLine(String line) {
        lines.add(line);
    }

    public static void addLabel(String label, int level) {
        addLine("#".repeat(Math.max(0, level)) + " " + label);
    }

    public static void addDetail(String detail) {
        addLine("* " + detail);
    }

    public static List<String> getLines() {
        return lines;
    }

    public static void write(Writer writer) {
        lines.forEach(line -> {
            try {
                writer.write(line);
                writer.write(System.lineSeparator());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void write(File file) {
        try (Writer writer = new FileWriter(file)) {
            write(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clear() {
        lines.clear();
    }
}
