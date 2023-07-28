package taskLesson;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.Temporal;

import static devlAPI.APIprintService.COMMON_DELIMETER;
import static devlAPI.APIprintService.println;

public class Lesson6 {

    private static class AccumlDeposit {
        static final int PERCENT_MONTH = 7;
        static final int TOTAL_SALARY = 12_000_000;

        static int accumulationAmount = 0;
        static int depositAmount = 15_000;
        static int sumPercent;

        static StringBuffer strBuffer = new StringBuffer();

        static String[] arrAccumulation = null;

        static void calcAcumulation() {
            sumPercent = AccumlDeposit.calcPercent(accumulationAmount);

            if ((accumulationAmount + depositAmount + sumPercent) < TOTAL_SALARY) {
                accumulationAmount += depositAmount + sumPercent;
            } else if ((TOTAL_SALARY - accumulationAmount) > sumPercent) {
                depositAmount = TOTAL_SALARY - accumulationAmount - sumPercent; // перерасчет суммы вклада
                accumulationAmount += sumPercent + depositAmount;
            } else {
                accumulationAmount += sumPercent;
                depositAmount = 0;  // сумма вклада обнуляется
            }
        }

        static void calcAcumulationNext() {
            sumPercent = AccumlDeposit.calcPercent(accumulationAmount);
            accumulationAmount += depositAmount + sumPercent;
        }

        static int calcPercent(int amountSum) {
            var data = new BigDecimal(amountSum * PERCENT_MONTH / 100., MathContext.DECIMAL32);
            var dataRound = data.setScale(0, BigDecimal.ROUND_HALF_EVEN);

            return dataRound.intValue();
        }
    }

    private static DecimalFormat decimalFormat = new DecimalFormat("#,###");

    private static String decmForm(int number) {
        return decimalFormat.format(number);
    }

    private static String getStrMonth(int month){
        String res = switch (month){
            case 1 -> "янв";
            case 2 -> "фев";
            case 3 -> "мар";
            case 4 -> "апр";
            case 5 -> "май";
            case 6 -> "июн";
            case 7 -> "июл";
            case 8 -> "авг";
            case 9 -> "сен";
            case 10 -> "окт";
            case 11 -> "ноя";
            case 12 -> "дек";
            default -> "empty";
        };

        return res;
    }

    private static void task1() {
        println(COMMON_DELIMETER + "task1");

        // программа выводит за первые 3 месячца и последние 3 месяца

        final int SUM_END = 2_459_000;
        final int SUM_ADD = 15_000;

        println("Конечная сумма накопления " + SUM_END + " месячные вложения " + SUM_ADD);

        int amountSaving = 0,
                sumInc;
        var numMonth = 0;

        // переменные для управления выводом строк
        var idPrintDelimiter = false;
        var limiterPrintLineForMonth = SUM_END / SUM_ADD - 2;

        while (amountSaving < SUM_END) {
            sumInc = (amountSaving + SUM_ADD) < SUM_END
                    ? SUM_ADD
                    : (SUM_END - amountSaving);  // остаток, который меньше SUM_ADD

            amountSaving += sumInc;
            if (++numMonth < 4 || numMonth > limiterPrintLineForMonth) {
                println("\tМесяц " + numMonth
                        + " сумма вложения " + sumInc
                        + " сумма накопления " + amountSaving);
            } else {
                if (!idPrintDelimiter) {
                    idPrintDelimiter = !idPrintDelimiter;
                    println("\t\t. . .");
                }
            }
        }
    }

    private static void task2() {
        println(COMMON_DELIMETER + "task2");

        final int BASE_NUMBER = 10;
        int index = 0;

        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        while (++index <= BASE_NUMBER) {
            sb.append(index + " ");
            sb2.append((BASE_NUMBER - index + 1) + " ");
        }

        println(sb.toString().trim());
        println(sb2.toString().trim());

    }

    private static void task3() {
        println(COMMON_DELIMETER + "task3");

        final int YEAR_START = 2023;
        final int YEAR_END = YEAR_START + 10;

        final int ADD_FOR_1000 = 17;
        final int DESC_1000 = 8;
        final int DIFR_BETWEEN_ADD_AND_DESK = ADD_FOR_1000 - DESC_1000;

        var populationAdd = 0;
        var totalPopulation = 12_000_000;

        println("На начало " + YEAR_START
                + " года кол-во населения составляло " + decmForm(totalPopulation));

        for (int year = YEAR_START; year < YEAR_END; year++) {
            populationAdd = totalPopulation * DIFR_BETWEEN_ADD_AND_DESK / 1000;
            totalPopulation += populationAdd;

            println("\tЗа " + year + " год"
                    + " увеличение начеления на " + decmForm(populationAdd)
                    + ", общая численность населения " + decmForm(totalPopulation));
        }
    }

    private static void task4(boolean printAll) {
        println(COMMON_DELIMETER + "task4");

        println("\tРасчет кол-ва месяцев для накопления "
                + decmForm(AccumlDeposit.TOTAL_SALARY)
                + " под " + AccumlDeposit.PERCENT_MONTH + "% процентов на каждый месяц");


        for (int month = 1;
             AccumlDeposit.accumulationAmount < AccumlDeposit.TOTAL_SALARY;
             month++) {

            AccumlDeposit.calcAcumulation(); // Процедура расчета наковлений

            AccumlDeposit.strBuffer.append("\t  Месяц " + month
                    + " ПроцНакопл " + decmForm(AccumlDeposit.sumPercent)
                    + " СумВклада " + decmForm(AccumlDeposit.depositAmount)
                    + " СумНакопления " + decmForm(AccumlDeposit.accumulationAmount) + "\n");
        }

        var sbStr = AccumlDeposit.arrAccumulation = AccumlDeposit.strBuffer.toString().split("\n");

        final int TOTAL_MONTH = sbStr.length;
        boolean printDelimenter = false; // управление выводом строк

        println("\tПотребуется кол-во месяцев " + TOTAL_MONTH);
        for (int i = 0; i < sbStr.length; i++) {
            if (printAll) {
                println(sbStr[i]);
            } else if (i < 3 || i > (TOTAL_MONTH - 4)) {
                println(sbStr[i]);
            } else if (!printDelimenter) {
                printDelimenter = !printDelimenter;
                println("\t...");
            } else {
                continue;
            }
        }

    }

    private static void task5() {
        println(COMMON_DELIMETER + "task5");
        println("\tВывести суммы накопления по каждому 6 месяцу");

        var sbStr = AccumlDeposit.arrAccumulation;
        for (int i = 5; i < sbStr.length; i += 6) {
            println(sbStr[i]);
        }
    }

    private static void task6() {
        println(COMMON_DELIMETER + "task6");
        println("\tСумма накоплений на каждые 6 месяцев в течении 9 лет");

        final int TOTAL_MONTH = 12 * 9 + 1;

        for (int month = 1; month < TOTAL_MONTH; month++) {

            AccumlDeposit.calcAcumulationNext(); // Процедура расчета наковлений

            if (month % 6 == 0) {
                println("\t  Месяц " + month
                        + " ПроцНакопл " + decmForm(AccumlDeposit.sumPercent)
                        + " СумВклада " + decmForm(AccumlDeposit.depositAmount)
                        + " СумНакопления " + decmForm(AccumlDeposit.accumulationAmount));
            }
        }
    }

    private static void task7() {
        println(COMMON_DELIMETER + "task7");

        var dateNow = LocalDate.now();
        var firstFriday = dateNow.with(TemporalAdjusters.dayOfWeekInMonth(1,DayOfWeek.FRIDAY));
        var lastFriday = dateNow.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));

        var period = firstFriday.until(lastFriday);
        var numWeeks = period.getDays()/7 + 1;
        int w = 0;

        println("\t"+ dateNow.getYear() + " " + getStrMonth(dateNow.getMonth().getValue()));
        for(var lDate = firstFriday; w < numWeeks; w++, lDate = lDate.plusWeeks(1) ){
            println("\t  Сегодня пятница, " + lDate.getDayOfMonth() + " -е число. Необходимо подготовить отчет");
        }

    }

    private static void task8(){
        println(COMMON_DELIMETER + "task8");

        println("\tРасчет появления кометы");

        var yearNow = LocalDate.now().getYear();
        var firstYearForStart = LocalDate.of(79, Month.JANUARY, 1).getYear();

        var Befor200FromNow = yearNow - 200;
        var yearEnd = yearNow + 100;

        var startYear = firstYearForStart;

        // Год Первого появления кометы после даты 0079.01.01 начиная с Befor200FromNow
        for (; startYear <= Befor200FromNow; startYear += 79 ){ }

        for(var year = startYear; year <= yearEnd; year += 79){
            println("\t  Появление кометы в " + year + " году");
        }
    }

    public static void runAllTask() {
        println("********* Домашнее задание 6 *********");

        task1();
        task2();
        task3();

        // false -> вывод в консоль первые и последние 3 месяца
        // true ВЕСЬ список
        task4(false);
        task5();
        task6();
        task7();
        task8();

    }

}
