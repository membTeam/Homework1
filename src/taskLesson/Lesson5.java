package taskLesson;

import static devlAPI.APIprintService.*;

public class Lesson5 {


    private static void task1() {
        println(COMMON_DELIMETER + "task1");
        println("Вывод чисел с нарастанием");

        final int BEGIN = 1;
        final int END = 10;

        for (int i = BEGIN; i <= END; i++) {
            println("number: " + i);
        }

    }

    private static void task2() {
        println(COMMON_DELIMETER + "task2");
        println("Вывод чисел с убыванием");

        final int BEGIN = 10;
        for (int i = BEGIN; i > 0; i--) {
            println("number: " + i);
        }
    }

    private static void task3() {
        println(COMMON_DELIMETER + "task3");
        println("Вывести четные числа от 0 до 17");

        var counter = 0;
        for (int i = 0; i <= 17; i++) {
            if (i % 2 == 0) {
                counter++;
                println("number " + i);
            }
        }

        println("Всего четных чисел: " + counter);
    }

    private static void task4() {
        println(COMMON_DELIMETER + "task4");
        println("Вывести числа от 10 до -10");

        final int BEGIN = 10;
        final int END = -10;

        for (int i = BEGIN; i >= END; i--) {
            println("number: " + i);
        }
    }

    private static void task5() {
        println(COMMON_DELIMETER + "task5");
        println("все високосные года, с 1904 года до 2096");

        final int END = 2096;
        final int BEGIN = 1904;
        var counter = 0;

        for (int i = BEGIN; i <= END; i += 4, counter++) {
            println(i + " год является високосным");
        }

        println("В заданном интервале високосный год встретился " + counter + " раз");
    }

    private static void task6() {
        println(COMMON_DELIMETER + "task6");
        println("Вывод последовательности чисел");

        final int INC = 7;
        for (int i = 7; i <= 98; i += INC) {
            println("Number: " + i);
        }
    }

    private static void task7() {
        println(COMMON_DELIMETER + "task7");

        println("Умножение на 2");

        final int END = 512;
        int count = 1;
        for (int i = 1; i <= END; i <<= 1, count++) {
            println(count + ". number " + i);
        }
    }

    private static void onlyForTask8orTask9(String numTask, int salary, int percentYear) {

        if (!(numTask.equals("task8") || (numTask.equals("task9")))) {
            println("Только для task8 or task9");
            return;
        }

        println(COMMON_DELIMETER + numTask);

        boolean task8 = numTask.equals("task8"),
                task9 = !task8;

        // переменные для расчета
        int percentMounth = task9
                ? percentYear / 12
                : 0;

        int totalWithPercent = 0;
        int sumPercent;
        int totalSumPercesnt = 0;

        // Общий заголовок
        if (task8) {
            println("Сумма накоплений в копилке от вложений на каждый месяц: " + salary);
        } else {
            println("Сумма годовых накоплений от суммы " + salary
                    + " годовая ставка " + percentYear);
        }

        for (int i = 0; i < 12; i++) {
            sumPercent = (totalWithPercent * percentMounth / 100);
            if (task9) {
                totalSumPercesnt += sumPercent;
            }

            totalWithPercent += sumPercent + salary;

            if (task9) {
                println("месяц " + (i + 1)
                        + " надбавка по %вклада: " + sumPercent
                        + " Итого " + totalWithPercent);
            } else {
                println("месяц " + (i + 1) + " Итого " + totalWithPercent);
            }
        }

        if (task9) {
            println("Общая накопительная сумма за год: " + totalSumPercesnt);
        }

    }

    private static void task10() {
        println(COMMON_DELIMETER + "task10");
        println("Таблица умножения на 2");

        final int CONST = 2;
        int res = CONST;
        for (int i = 1; i < 11; res = ++i * CONST) {
            println("2 * " + i + " = " + res);
        }

    }

    public static void runAllTask() {
        println("********* Домашнее задание 5 *********");

        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();

        // задача 8 percentYear = 12 в этом вызове метода обнуляется
        onlyForTask8orTask9("task8", 29000, 12);
        // задача 9
        onlyForTask8orTask9("task9", 29000, 12);

        task10();
    }
}
