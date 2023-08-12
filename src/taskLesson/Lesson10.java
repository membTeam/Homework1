package taskLesson;

import java.time.*;

import static devlAPI.APIprintService.*;

public class Lesson10 {

    enum ETypeDevicd {
        iOS("iOS"), andr("Android");

        private String strType;

        ETypeDevicd(String os) {
            strType = os;
        }

        public String strDevice() {
            return strType;
        }
    }

    record recordDevice(int phoneYear, ETypeDevicd typeDevice) {
        public String toStrint() {
            return "Телефон: "
                    + this.typeDevice().strDevice() + " "
                    + this.phoneYear() + "г.";
        }

    }

    private static class ServiceForMessage {

        static {
            nowYear = 2015;
        }
        private static int nowYear;
        public static String getMessage(recordDevice recDevice) {

            var strMes = recDevice.toStrint() + "\n";
            strMes += recDevice.phoneYear() < nowYear
                    ? "\tУстановите облегченную версию приложения для "
                        + recDevice.typeDevice().strDevice() + " по ссылке"
                    : "\tДля " + recDevice.phoneYear()
                        + " года создания телефона используйте переменную clientDeviceYear, "
                        + "в которой необходимо указать " + nowYear + " год";

            return strMes;
        }
    }

    static recordDevice[] arrRecordDevice = new recordDevice[]{
            new recordDevice(2013, ETypeDevicd.andr),
            new recordDevice(2013, ETypeDevicd.iOS),

            new recordDevice(2015, ETypeDevicd.andr),
            new recordDevice(2015, ETypeDevicd.iOS),

            new recordDevice(Year.now().getValue(), ETypeDevicd.andr),
            new recordDevice(Year.now().getValue(), ETypeDevicd.iOS)
    };

    private static String messageForDistance(int distance){

        final int FOR_ONE_DAY = 20,
                    FOR_TWO_DAY = 60,
                    FOR_THREE_DAY = 100,
                    ONE_DAY = 1;

        var strTempl = "\tНа расстояние " + distance+ "км потребуется: ";

        var res =  (distance < FOR_ONE_DAY)
                ? ONE_DAY + " день"
                : (distance < FOR_TWO_DAY)
                    ? (ONE_DAY + 1) + " дня"
                    : (distance < FOR_THREE_DAY)
                        ? (ONE_DAY + 2) + " дня"
                        : " доставка не возможна";

        return strTempl + res;
    }

    private static void task1(int[] arrYear) {
        println(COMMON_DELIMETER + "task1");

        println("Определение высокосный/неВысокосный год из массива");

        for (int item = 0; item < arrYear.length; item++) {
            var year = arrYear[item];

            if (Year.of(year).isLeap()) {
                println("\t" + year + " год — високосный год");
            } else {
                println("\t" +year + " год — не високосный год");
            }
        }
    }

    private static void task2(){
        println(COMMON_DELIMETER + "task2");
        println("Вывод сообщений на установку обновления телефона");

        for (var item: arrRecordDevice){
            println(ServiceForMessage.getMessage(item));
        }
    }

    private static void task3(int[] arrDistance){
        println(COMMON_DELIMETER + "task3");
        println("Сообщение клиенту о сроках доставки");

        for (var item : arrDistance){
            println(messageForDistance(item));
        }
    }

    public static void runAllTask() {
        println("********* Домашнее задание 10 *********");

        task1(new int[]{2011, 2012, 2016, 2023});
        task2();
        task3(new int[] {10, 20, 25, 60, 70, 100});

    }

}
