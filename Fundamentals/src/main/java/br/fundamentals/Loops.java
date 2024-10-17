package br.fundamentals;

import java.util.Random;
import java.util.Scanner;

public class Loops {

    //------------   METHODS  ----------------
    public static void GradesMean() {
        int n;
        double grade = 0;
        double sum = 0;

        System.out.println("Type how many grades you will enter: ");
        Scanner scanner = new Scanner(System.in); // This Scanner is still used inside this method
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.printf("Type the grade %d: ", i);
            grade = scanner.nextDouble();
            sum = sum + grade;
        }
        System.out.printf("The average of the grades is: %.2f\n", sum / n);
    }

    public static boolean OddCheck(int number) {
        return (number % 2) != 0;
    }

    public static void PrintOdd() {
        for (int i = 1; i <= 500; i++) {
            if (OddCheck(i)) {
                System.out.println(i);
            }
        }
    }

    public static void GuessGame(){
        //generatin random number between 0-50
        Random random = new Random();
        int number = random.nextInt(51);

        System.out.println("You have 5 chances to guess the random number between 0-100");
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.printf("Try number %d: ", i);
            int guess = scanner.nextInt();

            if(guess == number){
                System.out.println("You guessed the correct number");
                return;
            }else{
                System.out.println("Wrong number, try again!");
            }
        }

        System.out.printf("The random number was: %d\n", number);
    }

    public static void PositiveOrNegative() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("Type an integer number: ");
        if (number < 0) {
            System.out.println("Negative number");
        }else{
            System.out.println("Positive number");
        }
    }

    public static void FactorialFor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type an integer number to calculate the factorial!: ");
        int number = scanner.nextInt();
        int factorial = 1;

        for (int i = number; i > 1; i--) {
            factorial *= i;
        }

        System.out.println("Factorial of " + number + "! is: " + factorial);
    }

    public static void FactorialWhile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type an integer number to calculate the factorial!: ");
        int number = scanner.nextInt();
        int factorial = 1;
        int i = number;

        while (i > 1) {
            factorial *= i;
            i--;
        }

        System.out.println("Factorial of " + number + " is: " + factorial);
    }

    public static int FactorialRecursive(int number) {
        if (number <= 1) {
            return 1; // Caso base
        }
        return number * FactorialRecursive(number - 1); // Chamada recursiva
    }

    //---------- MENU DISPLAY ------------
    public static void Menu() {
        // Single Scanner object for all inputs
        Scanner scanner = new Scanner(System.in);
        while (true) {
//            System.out.println("1. Grades Calculator");
//            System.out.println("2. Print Odds");
//            System.out.println("3. Guess Game");
//            System.out.println("4. Positive or negative");
//            System.out.println("5. Factorial");
//            System.out.println("6. Exit");
//            System.out.print("Enter your choice: ");


            //USING TEXT BLOCK - JAVA 15 FEATURE :
            String menu = """
                    1. Grades Calculator
                    2. Print Odds
                    3. Guess Game   
                    4. Positive Or Negative
                    5. Factorial
                    6. Exit""";
            System.out.println(menu);

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    GradesMean(); // Will use the same Scanner instance
                    break;
                case 2:
                    PrintOdd();
                    break;
                case 3:
                    GuessGame();
                    break;
                case 4:
                    PositiveOrNegative();
                    break;
                case 5:
                    FactorialFor();
                    break;
                case 6:
                    System.out.println("Exiting the program ...");
                    scanner.close(); // Close the Scanner only when exiting the loop
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input!");
                    break;
            }
        }
    }

    //------------- MAIN -----------------
    public static void main(String[] args) {
        Menu();
    }
}