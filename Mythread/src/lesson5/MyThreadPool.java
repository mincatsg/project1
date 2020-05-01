package lesson5;

import lesson4.MyBlockingQueue;

public class MyThreadPool {  //自已实现变量池.(固定变量池)

   private Thread[] threads;

   private MyBlockingQueue<Runnable> workQueue;

    public MyThreadPool(int capacity, int size){
         threads = new Thread[capacity];
        workQueue = new MyBlockingQueue<>(size);
        for(int i = 0; i < capacity; i++){
            threads[i] = new MyThread(workQueue);
            threads[i].start();
        }
    }

    public void execute(Runnable task){
        try {
            workQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread{

        private MyBlockingQueue<Runnable> workQueue;

        public MyThread(MyBlockingQueue<Runnable> workQueue){
            this.workQueue = workQueue;
        }
        @Override
        public void run() {
           //TODO
            while(true){
                try {
                    Runnable task = workQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(5,6);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("task");
            }
        };
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    pool.execute(task);
                }
            }).start();
        }
    }

}
