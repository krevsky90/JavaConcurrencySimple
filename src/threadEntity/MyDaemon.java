package threadEntity;

import test.Main;
import utils.Writer;

public class MyDaemon extends Thread {
    private int counter = 5;

    public MyDaemon() {
        setDaemon(true);
    }
    @Override
    public void run() {
        while(counter > 0) {
            try {
                Thread.sleep(1000);
                Writer.write("Hello from MyDaemon!", Main.file2);
                counter--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Writer.write("MyDaemon is dead!", Main.file2);
    }
}
