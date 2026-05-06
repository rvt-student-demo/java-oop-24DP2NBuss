package rvt.ToDoList.GUI;

import java.util.List;

public class TDL {
    private final TDLCSV storage;

    public TDL() {
        this.storage = new TDLCSV();
        this.storage.LoadFromFile();
    }

    public String add(String item) {
        try {
            storage.add(item);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void print() {
        storage.print();
    }

    public void Completed(int index) {
        storage.Completed(index);
    }

    public boolean completeByIndex(int index) {
        if (index < 1 || index > storage.GetLastID()) {
            return false;
        }
        storage.Completed(index);
        return true;
    }

    public List<String> getTasks() {
        return storage.getTasks();
    }
}
