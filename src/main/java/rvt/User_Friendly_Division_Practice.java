package rvt;
import java.util.InputMismatchException;
import java.util.Scanner;

public class User_Friendly_Division_Practice {
    public static void main(String[] args) {
        int num2 = 0;
        int num1 = 0;
        Scanner scanner = new Scanner(System.in);

        outerLoop:
        while(true) {
            try {
            System.out.println("Enter the numerator: ");
            String num1input = scanner.next();

            if(num1input.length() > 0) {
                char first = num1input.charAt(0);
                    if(first == 'q' || first == 'Q') {
                        break outerLoop;
                        }
                    }

            num1 = Integer.parseInt(num1input);
                System.out.println("Enter the divisor: ");
            num2 = scanner.nextInt();

            }

            catch (InputMismatchException e) {
                System.out.println("You entered bad data.");
                System.out.println("Please try again");
                scanner.nextLine();
                    continue outerLoop;
            }

            if(num2 <= 1) {
                System.out.println("You can't divide " + num1 + " by " + num2);
                    continue;
            }

            int sum = (num1 / num2);
                System.out.println(num1 + " / " + num2 + " is " + sum);
            }
        }
    }
