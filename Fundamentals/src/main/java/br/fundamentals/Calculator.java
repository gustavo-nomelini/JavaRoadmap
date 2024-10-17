package br.fundamentals;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            //input two numbers
            System.out.println("Type the first number: ");
            double n1 = scanner.nextDouble();
            System.out.println("Type the second number: ");
            double n2 = scanner.nextDouble();

            //print menu:
            System.out.println("Choose the operation: ");
            System.out.println("1. Sum");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            int option = scanner.nextInt();


            //switch for the menu
            switch (option) {
                case 1:
                    System.out.println("Sum = " + (n1 + n2));
                    break;

                case 2:
                    System.out.println("Subtract = " + (n1 - n2));
                    break;

                case 3:
                    System.out.println("Multiply = " + (n1 * n2));
                    break;

                case 4:
                    if (n2 != 0) {
                        System.out.println("Divide = " + (n1 / n2));
                    } else {
                        System.out.println("You cant divide by zero");
                    }
                    break;

                case 5:
                    System.out.println("Program Finished!");
                    scanner.close();
                    return; // end main method

                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("");
        }
    }
}
