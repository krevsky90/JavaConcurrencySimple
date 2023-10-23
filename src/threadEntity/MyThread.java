package threadEntity;

import actions.EmptyElementHandler;

public class MyThread extends Thread {
    private String element;
    private long startTime;

    public MyThread(String element) {
        new MyThread(element, System.currentTimeMillis());
    }

    public MyThread(String element, long startTime) {
        this.element = element;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        try {
            EmptyElementHandler.handleElement(element, startTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
