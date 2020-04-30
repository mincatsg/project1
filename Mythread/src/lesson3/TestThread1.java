package lesson3;

class MyThread2 implements Runnable {
    private boolean flag;
    private Object obj;

    public MyThread2(boolean flag, Object obj) {
        super();
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod() {
        synchronized (obj) {
            try {
                while (true) {
                    System.out.println("wait()方法开始.. " +
                            Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait()方法结束.. " +
                            Thread.currentThread().getName());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void notifyMethod() {
        synchronized (obj) {
            try {
                System.out.println("notify()方法开始.. " + Thread.currentThread().getName());
                obj.notifyAll();
                System.out.println("notify()方法结束.. " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    } @
            Override
    public void run() {
        if (flag) {
            this.waitMethod();
        } else {
            this.notifyMethod();
        }
    }
}
public class TestThread1 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread2 waitThread = new MyThread2(true, object);
        MyThread2 notifyThread = new MyThread2(false, object);
        Thread thread1 = new Thread(waitThread, "wait线程");
        Thread thread2 = new Thread(waitThread, "wait线程");
        Thread thread3 = new Thread(waitThread, "wait线程");
        Thread thread4 = new Thread(notifyThread, "notify线程");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(4000);
        thread4.start();
        System.out.println("main方法结束!!");
    }
}
