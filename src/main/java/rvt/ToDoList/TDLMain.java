package rvt.ToDoList;

import java.util.*;

public class TDLMain {
    public static void main(String[] args) {
        TDL list = new TDL();
        Scanner scanner = new Scanner(System.in);
        UserInterface UserInt = new UserInterface(list, scanner);
        UserInt.RunInterface();
    }
}