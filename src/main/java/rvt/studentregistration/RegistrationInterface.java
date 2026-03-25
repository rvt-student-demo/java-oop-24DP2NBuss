package rvt.studentregistration;

import java.util.Scanner;

public class RegistrationInterface {
    private final Registration registrate = new Registration(); // te glabājas darbības ar studentu datiem
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("commands:\n help\n show\n register\n remove\n edit\n exit"); // parāda pieejamās komandas

        while (true) { // cikls strādā, līdz lietotājs ievada exit
            System.out.println("Enter command: ");
            String command = scanner.nextLine(); // nolasām lietotāja komandu
            if (command.equals("register")) {
                registrate.register();
                continue;
            } else if (command.equals("show")) {
                registrate.show();
                continue;
            } else if (command.equals("remove")) {
                registrate.remove();
                continue;
            } else if (command.equals("edit")) {
                registrate.edit();
                continue;
            } else if (command.equals("exit")) {
                break; // beidzam programmas izvēlni
            } else if (command.equals("help")) {
        
        System.out.println("Enter a command:\n help\n show\n register\n remove\n edit\n exit");

            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}