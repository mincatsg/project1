package lessonG3;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {

    public static void main(String[] args) {

        //不使用多线程：啥事情都自己干
        System.out.println("送快递到北京");
        System.out.println("送快递到上海");
        System.out.println("做自己的事情");

        //使用多线程：雇佣两个人来送快递
        // （有了送快递的任务，再雇佣人（创建线程），发布招聘信息时间消耗比较大）
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到北京");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到上海");
            }
        }).start();
        System.out.println("做自己的事情");

//        ExecutorService pool = Executors.newSingleThreadExecutor();//一个数量的固定线程池
//        ExecutorService pool = Executors.newFixedThreadPool(4);//只有正式员工
//        ExecutorService pool = Executors.newCachedThreadPool();//没有正式员工，只有临时工
//        ExecutorService pool = Executors.newScheduledThreadPool(4);//定时任务的线程池

        // new ThreadPoolExecutor：创建快递公司
        ExecutorService pool = new ThreadPoolExecutor(
                3,//核心线程数：正式员工数量（公司创建的时候，正式员工就招聘好入职了）
                5,//最大线程数：正式员工数量+临时工的数量
                60,//3、4个参数，表示临时工最大的空闲时间
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),//阻塞队列：保存任务的队列，快递公司存放快递包裹的仓库
                new ThreadFactory(){//线程创建的工厂类：招聘员工的要求、规则

                    @Override
                    public Thread newThread(Runnable r) {
                        return new MyThread();
                    }
                },
                //拒绝策略：
                //CallerRunsPolicy：谁让我执行任务，我是拒绝的，让他自己执行。快递公司不收快递，让我送快递
                //AbortPolicy：拒绝执行任务，抛出异常RejectedExecutionException。
                //DiscardPolicy：丢弃时间最新的任务。
                //DiscardOldestPolicy：丢弃时间最久的任务。
                new ThreadPoolExecutor.AbortPolicy()
        );
        //线程池的execute、submit就是提交任务的方法。把包裹交给快递公司送快递（快递把包裹放到仓库）
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到北京");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("送快递到上海");
            }
        });
        System.out.println("做自己的事情");
    }

    private static class MyThread extends Thread{
        private String name;
    }
}
