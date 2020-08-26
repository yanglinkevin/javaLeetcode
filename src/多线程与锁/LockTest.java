package 多线程与锁;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class LockTest {
    private Lock lock = new ReentrantLock();
    private Semaphore semaphore = new Semaphore(2);


    //需要参与同步的方法
    private void method(Thread thread) {
        lock.lock();
        try {
//            System.out.println("this state"+this.lock.getState() + "获得了锁");
            System.out.println("线程名"+thread.getName() + "获得了锁");
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("线程名"+thread.getName() + "释放了锁");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        //线程1
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}


/**
 * Created by liukai on 2016/2/25.
 * 测试 Lock、Condition 代替 synchronized、wait
 * 例子来自 JDK Condition API 中的示例代码，阻塞队列的原理。
 * 注间的是，两个不同的方法里面的 等待 和 唤醒 是不同的对象
 */
class TestCondition {

    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition notFull = lock.newCondition();
    private int count = 0;
    private int takeptr = 0;
    private int putptr = 0;
    Object [] blockArray = new Object[100];

    public static void main(String[] args) {
        final TestCondition condition = new TestCondition();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    condition.put(new Object());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(()->{
                try {
                    condition.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

    public void put (Object element) throws InterruptedException {
        try {
            lock.lock();
            while (count == blockArray.length) {
                System.out.println("put: putptr = " + putptr + ", await");
                full.await();       //等待和唤醒用的不是同一个对象
            }
            System.out.println("put: putptr = " + putptr + ", 执行 put");
            blockArray[putptr] = element;
            if (++putptr == blockArray.length) {
                putptr = 0;
            }
            ++count;
            notFull.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        Object data = null;
        try {
            while (0 == count) {
                System.out.println("take: takeptr == " + takeptr + "，await");
                notFull.await();
            }
            System.out.println("take: takeptr = " + takeptr + ", 执行 take");
            data = blockArray[takeptr];
            if (++takeptr == blockArray.length) {
                takeptr = 0;
            }
            --count;
            full.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }
}