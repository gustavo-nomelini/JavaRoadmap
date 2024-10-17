package br.fundamentals;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");


        String nome = "Gustavo";
        int age = 26;
        double height = 1.70;
        double weight = 65.0;

        System.out.println("My name is" + nome + "and I'm" + age + "years old.");
        //System.out.println(String.format("My name is %s and my age is %d", nome, age));

        if(age>=18){
            System.out.println("You are older than 18!");
        }else{
            System.out.println("You are not older than 18!");
        }

        double bmi = weight/(height*height);
        System.out.println("I have " + height + "m and my weight is " + weight + "Kg");
        System.out.printf("My bmi is %.2f", bmi);
    }
}