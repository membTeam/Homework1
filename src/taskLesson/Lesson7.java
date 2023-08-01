package taskLesson;

import java.util.Arrays;
import static devlAPI.APIprintService.*;

final class ArrStructure<T> {
    private T[] arrT;

    /**
     * вывод в консоль в прямом и обратном порядке
     *
     * @param sortUp
     */
    public void printArrExt(boolean sortUp) {
        var lengthArr = arrT.length;

        print("\t");
        if (sortUp) {
            for (var i = 0; i < lengthArr; i++) {
                print(arrT[i] + (i < lengthArr - 1 ? ", " : "\n"));
            }
        } else {
            for (var i = lengthArr - 1; i > -1; i--) {
                print(arrT[i] + (i > 0 ? ", " : "\n"));
            }
        }
    }

    /**
     * Вывод в консоль с использованием метода Arrays.toString(...)
     *
     * @return
     */
    public String printArr() {
        return Arrays.toString(arrT);
    }

    public int getLength(){
        return arrT.length;
    }

    public T[] getArray(){
        return arrT;
    }

    /**
     * Вывод в консоль через метод Arrays.toString(...)
     * @param ar
     */
    public ArrStructure(T[] ar) {
        arrT = ar;
        Arrays.sort(arrT);
    }
}

public class Lesson7 {
    static ArrStructure arrStructInt;
    static ArrStructure arrStructDouble;
    static ArrStructure arrStructShort;

    private static void task1() {
        println(COMMON_DELIMETER + "task1");

        arrStructInt = new ArrStructure(new Integer[]{1, 2, 3});
        arrStructDouble = new ArrStructure(new Double[]{1.57, 7.654, 9.986});
        arrStructShort = new ArrStructure(new Short[]{100, 92, 21});

        println("Создано 3 массива:");
        println("\tarrInt цлочисленный длина: " + arrStructInt.getLength() * 1
                + "\n\tarrDouble с плавающей точкой длина: " + arrStructDouble.getLength()
                + "\n\tarrShort целочисленный длина: " + arrStructShort.getLength()
        );
    }

    private static void task2() {
        println(COMMON_DELIMETER + "task2");

        println("  Целогчисленный массив arrInt");
        arrStructInt.printArrExt(true);

        println("  Массив с плавающей точкой arrDouble");
        arrStructDouble.printArrExt(true);

        println("  Произвольный Массив arrShort");
        arrStructShort.printArrExt(true);
    }

    private static void task3() {
        println(COMMON_DELIMETER + "task3");

        println("Вывод элементов массива в обратном порядке");

        println("  массив arrInt");
        arrStructInt.printArrExt(false);

        println("  массив arrDouble");
        arrStructDouble.printArrExt(false);

        println("  массив arrShort");
        arrStructShort.printArrExt(false);
    }

    private static void task4() {
        println(COMMON_DELIMETER + "task4");

        println("  Заменить не четные числа четными");
        var arrInt = arrStructInt.getArray();

        for (var i = 0; i < arrStructInt.getLength(); i++) {
            int data = (Integer) arrInt[i];
            if (data % 2 > 0) {
                arrInt[i] = data + 1;
            }
        }

        // используется метод Arrays.toString(arr);
        println("  \t" + (arrStructInt.printArr()));
    }

    public static void runAllTask() {
        println("********* Домашнее задание 7 *********");

        task1();
        task2();
        task3();
        task4();

    }
}
