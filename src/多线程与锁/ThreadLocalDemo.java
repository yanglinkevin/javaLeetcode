package 多线程与锁;

import java.util.Random;



class MyRunnable1 implements Runnable{
    private ThreadLocal<Integer>threadLocal=new ThreadLocal<>();
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread()+":"+threadLocal.get());
        threadLocal.set(new Random().nextInt(100));
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+":"+threadLocal.get());
    }
}

public class ThreadLocalDemo {
    public static void main(String[] args) {
        System.out.println("start");
        MyRunnable1 runnable=new MyRunnable1();
        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}