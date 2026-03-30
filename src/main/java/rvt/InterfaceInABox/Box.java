package rvt.InterfaceInABox;
import java.util.*;

public class Box implements Packable {
    private double weight;
    private double capacity;
    private ArrayList<Packable> contents = new ArrayList<Packable>();

    public Box (int capacity) {
        this.capacity = capacity;
        this.weight = 0;
    }

public void add(Packable item) {
    if (weight + item.weight() <= capacity) {
        contents.add(item);
        weight += item.weight();
    } else {
        System.out.println("Not enough space in the box.");
    }
}


    public double weight() {
        return this.weight;
    }

    public String toString() {
        return "Box: " + contents.size() + " items, total weight " + this.weight() + " kg";
    }
}
