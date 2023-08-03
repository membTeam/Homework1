package taskLesson;

import java.text.DecimalFormat;
import java.util.Arrays;

import static devlAPI.APIprintService.*;

public class Lesson8 {

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static int calcSum(int[] arr){
        int sumSalary = 0;
        for (int item : arr) {
            sumSalary += item;
        }

        return  sumSalary;
    }

    public static void task1() {
        int[] arr = generateRandomArray();

        println(COMMON_DELIMETER + "task1");
        println("\tВычисление затрат на зарплату работникам в течении месяца");

        var sumSalary = calcSum(arr);

        println("\tСумма трат за месяц составила " + sumSalary + " рублей");
    }

    private static void task2() {
        int[] arr = generateRandomArray();

        println(COMMON_DELIMETER + "task2");
        println("\tОпределение max and min трат за день");

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int item : arr) {
            if (min > item) {
                min = item;
            }
            if (max < item) {
                max = item;
            }
        }

        println("\t\tМинимальная сумма трат за день составила " + min
                + " рублей. "
                + "\n\t\tМаксимальная сумма трат за день составила " + max + "рублей");
    }

    private static void task3() {
        int[] arr = generateRandomArray();

        println(COMMON_DELIMETER + "task3");
        println("\tВычислить среднюю сумму затрат за месяц");

        var sumSalary = calcSum(arr);
        var averageValue = sumSalary / (double) arr.length;

        var decimalFormat  = new DecimalFormat("#.00");
        println("\t  Средняя сумма трат за месяц составила "
                + decimalFormat.format(averageValue) + " рублей");
    }

    private static void task4(){
        println(COMMON_DELIMETER + "task4");
        println("  Исправление бага с фамилией");

        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        // Копия массива для использования через StringBuffer
        char[] copyReverseFullName = Arrays.copyOf(reverseFullName, reverseFullName.length);

        println("\tИсходное состояние массива");
        print("\t\t ");
        System.out.println(reverseFullName);

        println("\t На основе цикла for");
        String strChars = new String(reverseFullName);
        for(int i = strChars.length() - 1, j = 0;  i > -1; i--, j++){
            // непосредственное исправление исхМассива
            reverseFullName[j] = strChars.charAt(i);
        }

        print("\t\t ");
        System.out.println(reverseFullName);

        // -----------------------------------

        println("\tС использованием StringBuffer");
        var strFromCopyArr = new String(copyReverseFullName);
        var strBuffer = new StringBuffer(strFromCopyArr);

        var reversFromCopyArr = strBuffer.reverse();

        // Исправленный массив copyReverseFullName
        reversFromCopyArr.getChars(0,
                copyReverseFullName.length,
                copyReverseFullName, 0 );

        print("\t\t ");
        System.out.println(copyReverseFullName);
    }

    public static void runAllTask() {
        println("********* Домашнее задание 8 *********");

        task1();
        task2();
        task3();
        task4();

    }

}
