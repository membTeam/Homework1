package taskLesson;

public class Lesson2 {

    private interface Calc {
        int calc(int val);
    }

    private record RecordTask8(int payroll, String name) {
    }

    private final static String DELIMITER = "---------- ";

    private static void print(String s) {
        System.out.println(s);
    }

    public static <T> void toStrAndPrint(T arg, String sVal) {
        var type = arg.getClass().getSimpleName().toLowerCase();

        String res = "Значение переменной " + sVal +
                " с типом " + type +
                " равно " + arg;

        // Значение переменной … с типом … равно …
        print(res);
    }

    public static void task1() {
        // int, byte, short, long, float, double
        byte bVal = 100;
        short sVal = 10000;
        int iVal = 100000;
        long lVal = 1_000_000;

        float fVal = 10.5f;
        double dVal = 100.5;

        print(DELIMITER + "task1");
        toStrAndPrint(bVal, "bVal");
        toStrAndPrint(sVal, "sVal");
        toStrAndPrint(iVal, "iVal");
        toStrAndPrint(lVal, "lVal");

        print("\n\tпеременные с плавающей точкой");
        toStrAndPrint(fVal, "fVal");
        toStrAndPrint(dVal, "dVal");

    }

    public static void task2() {

        var fVal = 27.12f;
        var lVal = 987_678_965_549L;
        var fVal2 = 2.786f;
        var sVal = 569;
        var sVal2 = -159;
        var iVal2 = 27897;
        var bVal = 67;

        print(DELIMITER + "task2");
        toStrAndPrint(fVal, "fVal");
        toStrAndPrint(lVal, "lVal");
        toStrAndPrint(fVal2, "fVal2");
        toStrAndPrint(sVal, "sVal");
        toStrAndPrint(sVal2, "sVal2");
        toStrAndPrint(iVal2, "iVal2");
        toStrAndPrint(bVal, "bVal");

    }

    public static void task3() {

        final int teacher1 = 23, teacher2 = 27, teacher3 = 30, totalPaper = 480;

        final int allChildren = teacher1 + teacher2 + teacher3;

        var res = totalPaper / allChildren;

        print(DELIMITER + "task3");
        print("На каждого ученика рассчитано " + res + " листов бумаги ");

    }

    public static void task4() {
        final byte for2Min = 16;
        final byte forOneDay = (24 * 60) / for2Min;
        final short forThreeDay = forOneDay * 3;
        final int forOneMonth = forOneDay * 30;

        print(DELIMITER + "task4");
        String res = "За 2 минуты " + " машина проивела " + for2Min + " штук бутылок\n" +
                "За сутки " + " машина проивела " + forOneDay + " штук бутылок\n" +
                "За 3 дня " + " машина проивела " + forThreeDay + " штук бутылок\n" +
                "За 1 месяц " + " машина проивела " + forOneMonth + " штук бутылок\n";

        print(res);

    }

    public static void task5() {
        final byte allBank = 120,
                whiteCol = 2,
                brownCol = 6;
        final byte numClass = allBank / (whiteCol + brownCol);

        short numWhiteBank = numClass * whiteCol;
        short numBrownBank = numClass * brownCol;

        // В школе, где … классов, нужно … банок белой краски и … банок коричневой краски
        print(DELIMITER + "task5");

        print("Всего куплено " + allBank + " банок краски");
        print("В школе, где "
                + numClass + " классов, нужно "
                + numWhiteBank + " белой краски и "
                + numBrownBank + " коричневой краски");

    }

    public static void task6() {
        /*Бананы — 5 штук (1 банан — 80 грамм).
        Молоко — 200 мл (100 мл = 105 грамм).
        Мороженое-пломбир — 2 брикета по 100 грамм.
        Яйца сырые – 4 яйца (1 яйцо — 70 грамм).*/

        final short numBananas = 5,
                numPacketMilk = 2,
                numEggs = 4,
                numBlockIce = 2;

        final short weightOnePacketMilk = 105,
                weightOneBlockIce = 100,
                weightOneEggs = 70,
                weightOneBananas = 80;

        final short weightBananas = numBananas * weightOneBananas,
                weightMilk = numPacketMilk * weightOnePacketMilk,
                weightIce = numBlockIce * weightOneBlockIce,
                weightEggs = numEggs * weightOneEggs;

        short gr = weightBananas + weightMilk + weightIce + weightEggs;
        float kGr = gr / (float) 1000;

        print(DELIMITER + "task6");
        print("Общий вес в граммах " + gr);
        print("Общий вес в килограммах " + kGr);

    }

    public static void task7() {
        final float reduce250 = (7 * (float) 1000) / 250,
                reduce500 = (7 * 1000f) / 500;

        print(DELIMITER + "task7");
        print("При похудении в день на 250 гр. потребуется " + reduce250 + " дней");
        print("При похудении в день на 500 гр. потребуется " + reduce500 + " дней");

    }

    public static void task8Ext() {
        Calc sumForMonth = (data) -> (int) (data * 1.1);
        Calc incForYear = (data) -> {
            int startVal = data * 12;
            return (int) (startVal * 1.1) - startVal;
        };
        Calc incForMonth = (data) -> {
            float addVal = sumForMonth.calc(data);
            return (int) addVal - data;
        };

        final int Masha = 67760,
                Denis = 83690,
                Christina = 76230;

        RecordTask8[] arRecTask8 = {
                new RecordTask8(Masha, "Masha"),
                new RecordTask8(Denis, "Denis"),
                new RecordTask8(Christina, "Christina")};

        print(DELIMITER + "task8Ext");
        for (RecordTask8 item : arRecTask8)
            print("Надбавка у " + item.name + " "
                    + incForMonth.calc(item.payroll) + " руб."
                    + " Теперь получает (" + sumForMonth.calc(item.payroll) + ")->"
                    + sumForMonth.calc(item.payroll)
                    + " руб. Годовой доход вырос на " + incForYear.calc(item.payroll) + " руб.");

    }

    public static void task8() {
        Calc sumForMonth = (val) -> (int) (val * 1.1);
        Calc incForYear = (val) -> {
            int startVal = val * 12;
            return (int) (startVal * 1.1) - startVal;
        };
        Calc incForMonth = (val) -> {
            float addVal = sumForMonth.calc(val);
            return (int) addVal - val;
        };

        /*Маша получает 67 760 рублей в месяц.
        Денис получает 83 690 рублей в месяц.
        Кристина получает 76 230 рублей в месяц.*/

        final int Masha = 67760,
                Denis = 83690,
                Christina = 76230;

        final int sumMonthForMasha = sumForMonth.calc(Masha),
                sumMonthForDenis = sumForMonth.calc(Denis),
                sumMonthForChristina = sumForMonth.calc(Christina);
        final int incForYearForMasha = incForYear.calc(Masha),
                incYearForDenis = incForYear.calc(Denis),
                incrYearForChristina = incForYear.calc(Christina);
        final int incMonthForMasha = incForMonth.calc(Masha),
                incMonthForDenis = incForMonth.calc(Denis),
                incMonthForChristina = incForMonth.calc(Christina);

        print(DELIMITER + "task8");
        print("Надбавка у Маши " + incMonthForMasha + " руб." +
                " теперь получает (" + Masha + ")->" + sumMonthForMasha +
                " руб. Годовой доход вырос на " + incForYearForMasha + " руб.");

        print("Надбавка у Дениса " + incMonthForDenis + " руб." +
                " теперь получает (" + Denis + ")->" + sumMonthForDenis +
                " руб. Годовой доход вырос на " + incYearForDenis + " руб.");

        print("Надбавка у Кристины " + incMonthForChristina + " руб." +
                " теперь получает (" + Christina + ")->" + sumMonthForChristina +
                " руб. Годовой доход вырос на " + incrYearForChristina + " руб.");

    }

}
