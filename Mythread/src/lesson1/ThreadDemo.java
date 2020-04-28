package lesson1;

import java.util.Random;

public class ThreadDemo {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            Random random = new Random();
            while(true){
                // 打印线程名称
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(random.nextInt(10));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        MyThread s1 = new MyThread();
        MyThread s2 = new MyThread();
        MyThread s3 = new MyThread();

        s1.start();
        s2.start();
        s3.start();

        Random random = new Random();
        while(true){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
