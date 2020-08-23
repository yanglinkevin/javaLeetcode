package 多线程与锁;

import java.util.Date;
/**
 * 这是⼀个简单的Runnable类，需要⼤约5秒钟来执⾏其任务。
 * @author shuang.kou
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.Time = " + new Date());
    }
    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}