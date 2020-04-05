package lessonG1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //1.继承Thread类，重写run方法
        //2.使用Runnable创建
        //3.使用Callable创建，有返回值，可以获取到线程的执行
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                //执行任务
                System.out.println("执行了一段任务");
                return "OK";
            }
        });
        new Thread(task).start();

        //当前线程（main线程）阻塞等待，直到线程执行完毕，并且获取到线程的执行结果
        System.out.println(task.get());
    }
}
