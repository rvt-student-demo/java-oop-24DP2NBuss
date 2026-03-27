package rvt.ToDoList;

public class TDL {
    private final TDLCSV storage;

    public TDL() {
        this.storage = new TDLCSV();
        this.storage.LoadFromFile();
    }

    public void add(String item) {
        try {
            storage.add(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void print() {
        storage.print();
    }

    public void Completed(int index) {
        storage.Completed(index);
    }
}
