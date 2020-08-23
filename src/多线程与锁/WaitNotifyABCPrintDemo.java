package 多线程与锁;

public class WaitNotifyABCPrintDemo {

    public static void main(String[] args) throws InterruptedException {
        Object lockA=new Object();
        Object lockB=new Object();
        Object lockC=new Object();
        ThreadWait t1=new ThreadWait("A",lockC,lockA);    //先获得C锁，然后对打印A的过程进行锁定，再释放A锁，再释放C锁
        ThreadWait t2=new ThreadWait("B",lockA,lockB);    //按照顺序获得A锁，获得B锁，打印B
        ThreadWait t3=new ThreadWait("C",lockB,lockC);
        t1.start();
        Thread.sleep(20);
        t2.start();
        Thread.sleep(20);
        t3.start();
    }

}


class ThreadWait extends Thread{
    private String name;
    private Object lock1;
    private Object lock2;


    public ThreadWait(String name,Object lockA,Object lockB) {
        this.name=name;
        this.lock1=lockA;
        this.lock2=lockB;
    }
    public void run() {
        int count=10;
        while(count>0) {
            synchronized(lock1) {        //先获得a锁，进入临界区
                synchronized(lock2) {
                    count--;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(name);
                    lock2.notify();          //在完成打印之后，将b的阻塞线程唤醒
                }
                try {
                    lock1.wait();        //调用wait方法终止当前线程
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}