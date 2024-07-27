package org.redthsgayclub.displacement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class FileUtil {

    public static void writeToFile(String content, boolean rewrite) {
        String filePath = System.getProperty("user.home") + "/Desktop/" + "Displacement mod output.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, !rewrite)) {
            if (rewrite) {
                fileWriter.write(content + System.lineSeparator());
            } else {
                fileWriter.write(content + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getTime() {
        return Calendar.getInstance().get(Calendar.YEAR) +
                "-" +
                Calendar.getInstance().get(Calendar.MONTH) +
                "-" +
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH) +
                " " +
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY) +
                "-" +
                (Calendar.getInstance().get(Calendar.MINUTE) +
                "-" +
                Calendar.getInstance().get(Calendar.SECOND));
    }

}