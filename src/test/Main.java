package test;

import threadEntity.MyDaemon;
import threadEntity.MyThread;
import utils.Writer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static File file2 = new File("testFile2.txt");

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();


        int numberOfElements = 10;
        Collection<String> elements = new ArrayList<String>(numberOfElements);
        for (int i = 0; i < numberOfElements; i++) {
            elements.add("element" + (i + 1));
        }

        Collection<Thread> threads = handleElementsParallels(elements, startTime);
        Thread daemon = new MyDaemon();
        daemon.start();

        Writer.write("main delta time (without waiting for other threads): " + (System.currentTimeMillis() - startTime), file2);

        //wait for other threads
        for (Thread tempThread : threads) {
            if (tempThread.isAlive()) {
                tempThread.join();
            }
        }

        Writer.write("main delta time (with waiting for other threads): " + (System.currentTimeMillis() - startTime), file2);
    }

    public static Collection<Thread> handleElementsParallels(Collection<String> elements, final long startTime) throws InterruptedException {
        Collection<Thread> threads = new ArrayList<Thread>(elements.size());

        for (String tempElement : elements) {
            threads.add(handleElementInParallel(startTime, tempElement));
        }

        return threads;
    }

    private static Thread handleElementInParallel(final long startTime, final String tempElement) {
        Thread thread = new MyThread(tempElement, startTime);
        thread.start();

        return thread;
    }

//    private static void handleElementInParallel(final long startTime, final String tempElement) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    handleElement(tempElement, startTime);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }

//    public static void handleElements(Collection<String> elements, long startTime) throws InterruptedException {
//        for (String tempElement : elements) {
//            handleElement(tempElement, startTime);
//        }
//    }

//    public static void handleElement(String element, long startTime) throws InterruptedException {
//        Thread.sleep(1000);
//        Writer.write(element + " is handled (" + (System.currentTimeMillis() - startTime) + ")");
//    }


}

