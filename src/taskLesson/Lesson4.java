package taskLesson;

import devlAPI.APIdevl;
import devlAPI.devlInterface;
import java.util.Scanner;

public class Lesson4 implements devlInterface {

    private static final String DELIMETER = "------ ";

    private static final String VERSIONOS = "Какая у Вас версия операционной системы (iOS=0 Android=1): ";

    private static void println(String str) {
        System.out.println(str);
    }

    private static void print(String str) {
        System.out.print(str);
    }

    private record resInput(boolean res, String mes, int resData) {
        public resInput(int resArg) {
            this(true, "ok", resArg);
        }

        public resInput(String str) {
            this(false, str, -1);
        }
    }

    private static Scanner scanner = null;

    private static resInput readFromScaner(int min, int max) {
        resInput resProc = null;

        boolean anyValue = min == 0 && max == 0;

        if (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int inputUser = scanner.nextInt();

                if (anyValue) {
                    resProc = new resInput(inputUser);
                } else {
                    if (inputUser >= min && inputUser <= max) {
                        resProc = new resInput(inputUser);
                    } else {
                        resProc = new resInput("Ошибка интервала");
                    }
                }
            } else {
                resProc = new resInput("Должно быть числовое значение");
            }
        }

        if ( resProc != null && !resProc.res()) {
            println(resProc.mes());
        }

        return resProc;
    }

    private static void task1() {

        println(DELIMETER + "task1");

        print(VERSIONOS);
        var resInput = readFromScaner(0, 1);
        if (resInput.res()) {
            int inputData = resInput.resData();

            if (inputData < 1) {
                println("Установите версию приложения для iOS по ссылке");
            } else {
                println("Установите версию приложения для Android по ссылке");
            }
        } else {
            println(resInput.mes());
        }
    }

    private static void task2() {

        println(DELIMETER + "task2");

        final int minYearPhone = 2015;
        final int minPhone = 2000,
            maxPhone = APIdevl.getCurrentYear();

        print("Введите год выпуска телефона (2000-" +maxPhone + "): ");

        resInput resProc = readFromScaner(minPhone, maxPhone);
        if (resProc.res()) {
            if (resProc.resData() < minYearPhone) {
                print(VERSIONOS);
                resProc = readFromScaner(0, 1);
                if (resProc.res()) {
                    String printStr = resProc.resData() == 1
                        ? "Для iOS оно будет звучать так: «Установите облегченную версию приложения для iOS по ссылке»"
                        : "Для Android: «Установите облегченную версию приложения для Android по ссылке»";

                    println(printStr);
                }
            } else {
                println("""
                        Для года создания телефона используйте переменную \
                        clientDeviceYear, в которой необходимо указать 2015 год""");
            }
        }
    }

    private static void task3(){
        println(DELIMETER + "task3");

        int minYear = 1900;

        print("Введите год для расчета (минЗначение " + minYear + ") ");
        var resScaner = readFromScaner(minYear, Short.MAX_VALUE);

        if (!resScaner.res()) return;
        int inputYear = resScaner.resData();

        boolean leapYear = (
                inputYear % 400 == 0
                        || inputYear % 100 == 0
                        || inputYear % 4 == 0 );

        if (leapYear){
            println("Год " + inputYear + " високосный");
        } else {
            println("Год " + inputYear + " не високосный");
        }

    }

    private static void task4(){
        println(DELIMETER + "task4");

        final int deliveryDistance = 95,
            numberDaysFor20 = 20,
            numberDaysFor60 = 60,
            numberDaysFor100 = 100;

            String strPrint = "";
            if (deliveryDistance < numberDaysFor20){
                strPrint = "Доставка карты сегодня";
            } else if (deliveryDistance < numberDaysFor60 ){
                strPrint = "Доставка карты завтра";
            } else if (deliveryDistance < numberDaysFor100 ) {
                strPrint = "Доставка карты через один день";
            } else {
                strPrint = "Доставка карты на такое расстояние не предусмотрено";
            }

            println(strPrint);
    }

    private static void task5(){
        println(DELIMETER + "task5");

        final int monthNumber = 12;

        String strPrint = switch (monthNumber){
            case 1,2,12 -> "Зима";
            case 3,4,5 -> "Весна";
            case 6,7,8 -> "Лето";
            case 9,10,11 -> "Осень";
            default -> "Ошибка параметра";
        };

        println(strPrint);
    }

    public static void runAllTask() {
        println("********* Домашнее задание 4 *********");

        try {
            scanner = new Scanner(System.in);

            task1();
            task2();
            task3();
            task4();
            task5();

        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}
