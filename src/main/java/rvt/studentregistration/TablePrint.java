package rvt.studentregistration;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TablePrint  {
    private final String path = "src/main/java/rvt/studentregistration/RegistrationTo.csv";

    public void printTable(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(path)); // nolasām visas rindas no faila

        List<String[]> rows = new ArrayList<>();
        for (String line : lines) {
            rows.add(line.split(",")); // sadalam rindu kolonnās pēc komata
        }

        if (rows.isEmpty()) return; // ja nav datu, nav ko drukāt

        int columnCount = rows.get(0).length; // nosakām kolonnu skaitu
        int[] columnWidths = new int[columnCount];

        for (String[] row : rows) {
            for (int i = 0; i < columnCount; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].trim().length()); // atrodam platāko tekstu katrā kolonnā
            }
        }

        printBorder(columnWidths);

        for (int i = 0; i < rows.size(); i++) {
            printRow(rows.get(i), columnWidths);

            if (i == 0) {
                printBorder(columnWidths); // pēc virsraksta uzzīmējam atdalošo līniju
            }
        }

        printBorder(columnWidths);
    }

    private void printBorder(int[] widths) {
        System.out.print("+");
        for (int width : widths) {
            System.out.print("-".repeat(width + 2) + "+"); // zīmējam vienas kolonnas augšējo/apakšējo malu
        }
        System.out.println();
    }

    private void printRow(String[] row, int[] widths) {
        System.out.print("|");
        for (int i = 0; i < widths.length; i++) {
            System.out.print(" " + padRight(row[i].trim(), widths[i]) + " |"); // pieliekam atstarpes, lai kolonnas būtu taisnas
        }
        System.out.println();
    }

    private String padRight(String text, int length) {
        return String.format("%-" + length + "s", text); // pieliek atstarpes pa labi līdz vajadzīgajam garumam
    }
}