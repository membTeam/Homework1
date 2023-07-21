
import devlAPI.RunLesson;
import devlAPI.RecordDevl.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Домашние задания Sky-pro");

        try {
            var resProc = RunLesson.runTask();
            if (!resProc.res())
                System.out.println(resProc.mes());
        }
        catch (Exception ex){
            System.out.println("err: " + ex.getMessage());
        }

    }
}