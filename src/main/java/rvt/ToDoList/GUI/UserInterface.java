package rvt.ToDoList.GUI;

import java.util.*;

public class UserInterface {
    private TDL list;
    private Scanner scanner;

    public UserInterface(TDL theList, Scanner theScanner) {
        list = theList;
        scanner = theScanner;
    }

    public void RunInterface() {

        System.out.println("Commands:\n");
            System.out.println("list;");
            System.out.println("add;");
            System.out.println("completed;");
            System.out.println("stop;\n\n");

        while (true) {
            System.out.println("Command:");

            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else if (command.equals("list")) {
                list.print();
                continue;
            } else if (command.equals("add")) {
                System.out.print("Task: ");
                String task = scanner.nextLine();
                list.add(task);
                continue;
            } else if (command.equals("completed")) {
                System.out.print("Which task was completed? ");
                int taskIndex = Integer.valueOf(scanner.nextLine());
                list.Completed(taskIndex);
                continue;
            }
        }
    }
}