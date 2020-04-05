package lessonG1;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        int num = 10;
        Thread[] threads = new Thread[num];
        CountDownLatch cdl = new CountDownLatch(num);//给定初始值
        for(int i=0; i<10; i++){
            final int j = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                    cdl.countDown();//把数量进行--操作
                }
            });
            threads[i].start();
        }
        // 所有子线程执行完毕之后再执行下边的打印语句
        // 第一种方式：结合活跃线程数+线程让步
//        while (Thread.activeCount() > 1)
//            Thread.yield();
        // 第二种，线程等待join的方式
//        for(int i=0; i<10; i++){
//            threads[i].join();
//        }
        // 第三种：使用CountDownLatch
        cdl.await();//当前线程阻塞等待，直到CountDownLatch数量为0，就可以往下执行
        System.out.println("所有线程都执行完毕");
    }
}
