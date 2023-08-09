package taskLesson;

import static devlAPI.APIprintService.*;

public class Lesson9 {

    private static String firstName;
    private static  String middleName;
    private static String lastName;
    private static String fullName;

    private static void initialData(){
        firstName = "Ivan";
        middleName = "Ivanovich";
        lastName = "Ivanov";

        fullName = lastName + " " + firstName + " " + middleName;
    }


    private static void task1() {
        println(COMMON_DELIMETER + "task1");
        initialData();

        println("ФИО сотрудника — " + fullName);
    }

    private static void task2(){
        println(COMMON_DELIMETER + "task2");
        println("Изменение символов ФИО на верхний регистр");

        var strPrint = fullName.toUpperCase();
        println("Данные ФИО сотрудника для заполнения отчета — "
                + strPrint);
    }

    private static void task3(){
        println(COMMON_DELIMETER + "task3");
        println("Замена char ё на е");

        var fullName = "Иванов Семён Семёнович";
        println("Исходное ФИО сотрудника — " + fullName);

        fullName = fullName.replace('ё', 'е');
        println("Данные ФИО сотрудника — " + fullName);
    }

    public static void runAllTask() {
        println("********* Домашнее задание 9 *********");

        task1();
        task2();
        task3();

    }

}
