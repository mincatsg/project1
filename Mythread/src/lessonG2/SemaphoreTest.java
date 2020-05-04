package lessonG2;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        // 有限资源并发处理的逻辑
//        Semaphore semaphore = new Semaphore(1000);
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    semaphore.acquire();
//                    //http请求处理
//                    //。。。
//                }catch (Exception e){
//                    e.printStackTrace();
//                }finally {
//                    semaphore.release();
//                }
//            }
//        };
//        ExecutorService pool = Executors.newCachedThreadPool();
//        for(int i=0; i<10000; i++){
//            pool.execute(task);
//        }

        int num = 10;
        Thread[] threads = new Thread[num];
        Semaphore semaphore = new Semaphore(0);
        for(int i=0; i<10; i++){
            final int j = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                    semaphore.release();
                }
            });
            threads[i].start();
        }
        semaphore.acquire(num);
        System.out.println("所有线程都执行完毕");
    }
}
