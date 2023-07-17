package taskLesson;

public class Lesson1 {
    public static void task1(){
        System.out.println("------- data for task 1");
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;

        System.out.println("dog: " + dog);
        System.out.println("cat: " + cat);
        System.out.println("paper: " + paper);
    }

    public static void task2(){

        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;

        dog += 4;
        cat += 4;
        paper += 4;

        System.out.println("\n------- data for task 2 (for all value add 4)");
        System.out.println("dog: " + dog);
        System.out.println("cat: " + cat);
        System.out.println("paper: " + paper);
    }

    public static void task3(){
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;

        dog -= 3.5;
        cat -= 1.6;
        paper -= 7639;

        System.out.println("\n------- data for task 3");
        System.out.println("dog - 3.5 = " + dog);
        System.out.println("cat - 1.6 = " + cat);
        System.out.println("paper - 7639 = " + paper);
    }

    public static void task4(){
        System.out.println("\n------- data for task 4");
        var friend = 19;
        System.out.println("friend: " + friend);

        friend *=2;
        System.out.println("friend * 2 = " + friend);

        friend /= 7;
        System.out.println("friend : 7 = " + friend);
    }

    public static void task5(){
        System.out.println("\n------- data for task 5");
        var frog = 3.5;
        System.out.println("frog: " + frog);

        frog *=10;
        System.out.println("frog * 10 = " + frog);

        frog /= 3.5;
        System.out.println("frog : 3.5 = " + frog);

        frog += 4;
        System.out.println("frog + 4 = " + frog);
    }

    public static void task6(){
        System.out.println("\n------- data for task 6");
        var boxer1 = 78.2;
        var boxer2 = 82.7;
        var total = boxer1 + boxer2;
        var diff = Math.abs(boxer1 - boxer2);

        System.out.println("Общая масса бойцов = " + total + " кг.");
        System.out.println("Разница между масссами бойцов = " + diff + " кг.");
    }

    public static void task7(){
        System.out.println("\n------- data for task 7");

        var boxer1 = 78.2;
        var boxer2 = 82.7;
        var diff = (boxer1 - boxer2) > 0 ? (boxer1 - boxer2) : (boxer2 - boxer1);
        System.out.println("(1-й способ) Разница между масссами бойцов = " + diff + " кг.");

        diff = (boxer1 / boxer2) > 1d ? (boxer1 - boxer2) : (boxer2 - boxer1);
        System.out.println("(2-й способ) Разница между масссами бойцов = " + diff + " кг.");
    }

    public static void task8(){
        final int totalHours = 640;
        final int hours = 8;
        final int totalWorkers = totalHours / hours;

        System.out.println("\n------- data for task 8");
        System.out.println("Всего работников в компании " + (totalHours / hours) + " человек");

        System.out.printf("Если в компании работает %d человек(а),\n\tто всего %d часов работы может быть поделено между сотрудниками",
                (totalWorkers + 94), ((totalWorkers + 94) * hours));
    }

    public static void  runAllTask(){
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }

}
