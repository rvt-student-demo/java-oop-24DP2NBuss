package rvt.InterfaceInABox;


public class BoxMain {
    public static void main(String[] args) {
        Box bigbox = new Box(10);
        Box smallBox = new Box(5);

        bigbox.add(new Book("Fyodor Dostoevsky", "Crime and Punishment", 2)) ;
        bigbox.add(new Book("Robert Martin", "Clean Code", 1));
        bigbox.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        bigbox.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        bigbox.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        bigbox.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        smallBox.add(new Book("Harry Potter", "Chamber of Secrets", 2));
        bigbox.add(smallBox);
        System.out.println(bigbox);
    }
}
