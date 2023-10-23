package utils;

import java.io.*;

public class Writer {
    public static void write(String text) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("testFile.txt", "UTF-8");
            printWriter.println(text);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void write(String text, File file) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
            printWriter.println(text);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
