package actions;

import test.Main;
import utils.Writer;

public class EmptyElementHandler {
    public static void handleElement(String element, long startTime) throws InterruptedException {
        Thread.sleep(1000);
        Writer.write(element + " is handled (" + (System.currentTimeMillis() - startTime) + ")", Main.file2);
    }
}
