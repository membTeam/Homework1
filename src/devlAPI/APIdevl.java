package devlAPI;

import java.util.Calendar;

public class APIdevl {
    public static int getCurrentYear(){
        var calendar = Calendar.getInstance();
        int yyyy = calendar.get(Calendar.YEAR);

        return  yyyy;
    }

}
