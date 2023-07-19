package taskLesson;

import devlAPI.devlInterface;

import java.util.Scanner;

public class Lesson3 implements devlInterface {

    private static final String DELIMETER = "------ ";

    private static void println(String str) {
        System.out.println(str);
    }

    private static void print(String str) {
        System.out.print(str);
    }

    private static Scanner scanner = null;

    private static void task1() {
        println(DELIMETER + "run task1");

        print("Сколько тебе лет: ");
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (scanner.nextInt() >= 18)
                    println("Ты совершеннолетний");
                else
                    println("Ты не достиг совершеннолетия, нужно немного подождать");
            }
            else println("Ошибка ввода. Д/быть целое число");
        }
    }

    private static void task2() {
        println(DELIMETER + "run task2");

        print("Какая температура воздуха на улице: ");
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (scanner.nextInt() <= 5)
                    println("На улице холодно, нужно надеть шапку");
                else
                    println("Сегодня тепло, можно идти без шапки");
            }
            else
                println("Ошибка ввода. Д/быть целое число");
        }
    }

    private static void task3() {
        println(DELIMETER + "run task3");

        print("Скорость автомобиля по прибору сотрудника ГИБДД: ");
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                if (scanner.nextInt() > 60) println("Придется заплатить штраф");
                else println("Можно ездить спокойно");
            } else println("Ошибка ввода. Д/быть целое число");
        }
    }

    private static void task4() {
        println(DELIMETER + "run task4");

        String strStart = "Если возраст человека равен ";

        print("Введите возраст: ");
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if (age < 7)
                    println(strStart + age + ", ему нужно ходить в детский сад");
                else if (age >= 7 && age < 18)
                    println(strStart + age + ", ему нужно ходить в школу");
                else if (age >= 18 && age < 24)
                    println(strStart + age + ", его место в университете");
                else
                    println(strStart + age + ", ему пора ходить на работу");
            } else
                println("Ошибка ввода. Д/быть целое число");
        }

    }

    private static void task5() {
        println(DELIMETER + "run task5");

        print("Введите возраст ребенка: ");
        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int age = scanner.nextInt();
                if (age < 5)
                    println("Он не может кататься на атракционе");
                else if (age < 14) {
                    System.out.print("У него есть сопровождающий? (y/n) ");
                    if (scanner.hasNext()) {
                        var sNext = scanner.next().toLowerCase();

                        if (sNext.length() == 1) {
                            if (sNext.equals("y") || sNext.equals("n"))
                                println("Он может кататься только в сопровождении взрослого");
                            else println("Без сопровождения кататься нельзя");
                        }
                        else println("Ошибка ввода: д/быть одиночный символ y or n");
                    }
                }
                else println("Он может кататься без сопровождения взрослого");
            }
            else  println("Ошибка ввода. Д/быть целое число");
        }

    }

    private static void task6() {
        println(DELIMETER + "run task6");

        final short allPassengeres = 102,
                numSeat = 60,
                numStanding = allPassengeres - numSeat;

        print("Введите кол-во желающих попасть в вагон: ");
        if (scanner.hasNext())
            if (scanner.hasNextInt()) {
                int resScan = scanner.nextInt();

                if (resScan > allPassengeres) {
                    int noPlace = resScan - allPassengeres;
                    println("Для " + noPlace + " пассажиров нет мест ");
                } else if (resScan > numSeat) {
                    int standingPlaces = numStanding - resScan - numSeat;
                    println("Есть стоячие места " + standingPlaces);
                } else {
                    int ExistStandingPlaces = numSeat - resScan;
                    println("Есть сидячие места " + ExistStandingPlaces + " и стоячие места " + numStanding);
                }

            } else
                println("Ошибка ввода. Д/быть целое число");
    }

    private static void task7() {
        println(DELIMETER + "run task7");

        final int one = 15,
                two = 110,
                three = 300;

        int buffer = two;
        String nameValue = "two";

        if (one > buffer) {
            buffer = one;
            nameValue = "one";
        }
        if (three > buffer) {
            buffer = three;
            nameValue = "three";
        }

        println("Из трех чисел: one=" + one
                + " two=" + two
                + " three=" + three +
                "  наибольшее значение " + nameValue + "=" + buffer);
    }

    public static void runAllTask() {

        println("********* Домашнее задание 3 *********");

        try {
            scanner = new Scanner(System.in);

            task1();
            task2();
            task3();
            task4();
            task5();
            task6();
            task7();

        } finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
