package 多线程与锁;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class SynDemo{
    public static void main(String args[]) throws InterruptedException {
        SynDemoRunnable synDemoRunnable = new SynDemoRunnable();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(2);
        arrayBlockingQueue.add(2);
        for(int j=0; j<100; j++) {
            Thread s = new Thread(synDemoRunnable);
            s.start();
            s.join();
        }
        AtomicRunnableDemo atomicRunnableDemo = new AtomicRunnableDemo();
        for(int j=0; j<100; j++) {
            Thread s = new Thread(atomicRunnableDemo);
            s.start();
            s.join();
        }
//        Thread.sleep(1000);
        System.out.println(synDemoRunnable.get());
        System.out.println(atomicRunnableDemo.get());
    }
}


class SynDemoRunnable implements Runnable{
    public static int i=0;
    @Override
    public void run() {
        synchronized (this) {
            for(int j=0; j<100; j++){
                i += 1;
            }
        }
    }
    public int get() {
        return i;
    }

}

class AtomicRunnableDemo implements Runnable{
    AtomicInteger i = new AtomicInteger(0);
    @Override
    public void run() {
        for(int j=0; j<100; j++){
                i.incrementAndGet();
        }
    }
    public AtomicInteger get() {
        return i;
    }

}
