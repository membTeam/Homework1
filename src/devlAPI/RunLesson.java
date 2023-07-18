package devlAPI;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

import devlAPI.RecordDevl.*;

/**
 * Менеджер запуска учебных программ
 * данные из файла info.txt
 */
public class RunLesson {

    public static RecordResProc runTask() throws IOException,
                ClassNotFoundException,
                InvocationTargetException,
                IllegalAccessException,
                NoSuchMethodException {

        String filePathInfo = "info.txt";
        //var file = new File(filePathInfo);
        if (! new File(filePathInfo).exists())
            throw  new IOException("Нет файла " + filePathInfo);

        byte[] byteFromFile = Files.readAllBytes(Paths.get(filePathInfo));
        String txtFile = new String(byteFromFile);

        String[] splitTxt = txtFile.split(" ");
        boolean bOption = Boolean.parseBoolean(splitTxt[0]);

        if ( !bOption )
            return new RecordResProc(false, "Отмена запуска программ из файла info.txt");

        String strTask = splitTxt[1];

        Class<?> classTask = Class.forName ("taskLesson." + strTask);
        Method taskMethod = classTask.getMethod("runAllTask");
        taskMethod.invoke(null);

        return new RecordResProc(true, "ok");

    }

}
