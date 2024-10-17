package br.fundamentals;
import java.time.*;

public class Time {
    public static void main(String[] args){

        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);

        LocalTime thisTime = LocalTime.now();
        System.out.println("This time : " + thisTime);

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Time : " + currentDateTime);

        LocalDate someDay = LocalDate.of(2020, Month.JUNE, 12);
        System.out.println("Someday : " + someDay);

        LocalTime someTime = LocalTime.of(23, 53);
        System.out.println("Sometime : " + someTime);

        LocalDateTime otherDateTime = LocalDateTime.of(2021, Month.MARCH, 4, 10,51,44);
        System.out.println("Other Date Time : " + otherDateTime);

    }
}