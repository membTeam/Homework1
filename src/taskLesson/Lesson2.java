package taskLesson;

import apiProj.ApiString;

public class Lesson2 {

    private interface Calc {
        int calc(int val);
    }

    private final static String DELIMITER = "---------- ";
    private static void p(String s){
        ApiString.p(s);
    }

    public static <T> void toStr_andPrint(T arg, String sVal){
        var type = arg.getClass().getSimpleName().toLowerCase();

        String res = "Значение переменной " + sVal +
                " с типом "  + type +
                " равно " + arg;

        // Значение переменной … с типом … равно …
        p(res);
    }

    public static void task1(){
        // int, byte, short, long, float, double
        byte bVal = 100;
        short sVal = 10000;
        int iVal = 100000;
        long lVal = 1_000_000;

        float fVal = 10.5f;
        double dVal = 100.5;

        p( DELIMITER + "task1");
        toStr_andPrint(bVal, "bVal");
        toStr_andPrint(sVal, "sVal");
        toStr_andPrint(iVal, "iVal");
        toStr_andPrint(lVal, "lVal");

        p("\n\tпеременные с плавающей точкой");
        toStr_andPrint(fVal,"fVal");
        toStr_andPrint(dVal, "dVal");

    }

    public static void task2(){

        var fVal = 27.12f;
        var lVal = 987_678_965_549L;
        var fVal2 = 2.786f;
        var sVal = 569;
        var sVal2 = -159;
        var iVal2 = 27897;
        var bVal = 67;

        p(DELIMITER + "task2");
        toStr_andPrint(fVal, "fVal");
        toStr_andPrint(lVal, "lVal");
        toStr_andPrint(fVal2, "fVal2");
        toStr_andPrint(sVal, "sVal");
        toStr_andPrint(sVal2, "sVal2");
        toStr_andPrint(iVal2, "iVal2");
        toStr_andPrint(bVal, "bVal");

    }

    public static void task3(){

        final int teacher1 = 23, teacher2 = 27, teacher3 = 30, totalPaper = 480;

        final int allChildren = teacher1 + teacher2 + teacher3;

        var res = totalPaper / allChildren;

        p(DELIMITER + "task3");
        p("На каждого ученика рассчитано " + res + " листов бумаги ");

    }

    public static void task4(){
        final byte for2Min = 16;
        final byte forOneDay = (24 * 60)/ for2Min;
        final short forThreeDay = forOneDay * 3;
        final int forOneMonth = forOneDay * 30;

        p(DELIMITER + "task4");
        String res = "За 2 минуты " + " машина проивела " + for2Min + " штук бутылок\n" +
                "За сутки " + " машина проивела " + forOneDay + " штук бутылок\n" +
                "За 3 дня " + " машина проивела " + forThreeDay + " штук бутылок\n" +
                "За 1 месяц " + " машина проивела " + forOneMonth + " штук бутылок\n";

        p(res);

    }

    public static void task5(){
        final byte allBank = 120, wCol = 2, mCol = 6;
        final byte numClass = allBank / (wCol + mCol);

        // В школе, где … классов, нужно … банок белой краски и … банок коричневой краски
        p(DELIMITER +"task5");

        p("Всего куплено " + allBank + " банок краски" );
        p("В школе, где " + numClass + " классов, нужно "
                + (numClass * wCol) + " белой краски и "
                + (numClass * mCol) + " коричневой краски"
        );

    }

    public static void task6(){
        /*Бананы — 5 штук (1 банан — 80 грамм).
        Молоко — 200 мл (100 мл = 105 грамм).
        Мороженое-пломбир — 2 брикета по 100 грамм.
        Яйца сырые – 4 яйца (1 яйцо — 70 грамм).*/

        final short bananas = 5 * 80,
                milk = 2 * 105,     // молоко
                ice = 2 * 100,      // моложенное
                rawEggs = 4 * 70;   // яйца сырые

        short gr = bananas + milk + ice + rawEggs;
        float kGr = (gr / 1000f);

        p(DELIMITER + "task6");
        p("Общий вес в граммах " + gr);
        p("Общий вес в килограммах " + kGr);

    }

    public static void task7(){
        final float reduce250 = (7 * 1000f)/250, reduce500 = (7 * 1000f)/500;

        p(DELIMITER + "task7");
        p("При похудении в день на 250 гр. потребуется " + reduce250 +" дней" );
        p("При похудении в день на 500 гр. потребуется " + reduce500 +" дней" );

    }

    public static void task8(){
        Calc _calcAfter = (val) -> {
                int startVal = val * 12;
                return (int) (startVal * 1.1) - startVal;  };

        Calc _calc = (val) -> (int) (val * 1.1);

        Calc _calAdd = (val) -> {
          float addVal = _calc.calc(val);
          return  (int) addVal - val;  };

        /*Маша получает 67 760 рублей в месяц.
        Денис получает 83 690 рублей в месяц.
        Кристина получает 76 230 рублей в месяц.*/

        final int Masha = 67_760, Denis = 83_690, Christina = 76_230;

        p(DELIMITER + "task8");
        p("Надбавка у Маши " + _calAdd.calc(Masha) + " руб." +
                " теперь получает (" + Masha + ")->" +  _calc.calc(Masha) +
                " руб. Годовой доход вырос на " + _calcAfter.calc(Masha) + " руб.");

        p("Надбавка у Дениса " + _calAdd.calc(Denis) + " руб." +
                " теперь получает (" + Denis + ")->" + _calc.calc(Denis) +
                " руб. Годовой доход вырос на " + _calcAfter.calc(Denis) + " руб.");

        p("Надбавка у Кристины " + _calAdd.calc(Christina) + " руб." +
                " теперь получает (" + Christina + ")->" + _calc.calc(Christina) +
                " руб. Годовой доход вырос на " + _calcAfter.calc(Christina) + " руб.");


    }

}
