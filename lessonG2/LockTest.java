package lessonG2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static int SUM;

    public static void test1(){
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        synchronized (LockTest.class){
                            SUM++;
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println(SUM);
    }

    public static void test2(){
        Lock lock = new ReentrantLock();
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        try {
                            lock.lock();
                            SUM++;
                        }finally {
                            lock.unlock();
                        }
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println(SUM);
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
