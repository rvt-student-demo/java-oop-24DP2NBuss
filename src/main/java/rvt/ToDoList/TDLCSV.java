package rvt.ToDoList;

import java.io.*;
import java.util.*;

public class TDLCSV {
    private ArrayList<String> todoList;
    private final String filePath = "src/main/java/rvt/ToDoList/TDL.csv";
    private final String taskRegex = "^[A-Za-z0-9 ]{3,}$";


    public TDLCSV() {
        this.todoList = new ArrayList<>();
    }

    public void print() {
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println((i + 1) + ": " + todoList.get(i));
        }
    }

    private void UpdateFile() {
        try (PrintWriter output = new PrintWriter(new FileWriter(filePath, false))) {
            output.println("id,task");
            for (int i = 0; i < todoList.size(); i++) {
                int index = i + 1;
                output.println(index + "," + todoList.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void Completed(int index) {
        todoList.remove(index - 1);
        UpdateFile();
    }

    public void LoadFromFile() {
        String line;
        boolean Header = true;
        todoList.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                if (Header) {
                    Header = false;
                    continue;
                }

                if (!line.trim().isEmpty()) {
                    String[] values = line.split(",", 2);
                    if (values.length == 2) {
                        todoList.add(values[1].trim());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int GetLastID() {
        return todoList.size();
    }

    public void add(String task) throws Exception {
        CheckEventString(task);
        int id = GetLastID() + 1;
        this.todoList.add(task);
        try (PrintWriter output = new PrintWriter(new FileWriter(filePath, true))) {
            output.println(id + "," + task);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public boolean CheckEventString(String value) throws Exception {
        if (value.matches(taskRegex)) {
            return true;
        } else {
            throw new Exception("Task must contain at least 3 letters, numbers and spaces."); 
        }
    }
}
