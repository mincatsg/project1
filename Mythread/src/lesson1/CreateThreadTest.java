package lesson1;

public class CreateThreadTest {
    public static void main(String[] args) {
        //判断进程是否结束: 看非守护进程是否结束
        // 非守护进程：自已new的进程
        //主进程结束,子进程不一定结束.
        //所有非守护进程结束,进程一定结束.


        //java进程的结束:
        //1. Runtime.exit()
        //2. 所以非守护进程都结束,进程才结束.
        Mythread thread = new Mythread("明明");  //JVM在操作系统创建一个线程,并申请CPU调度,是有时间调度的.
       // thread.run();  //只是调用一个实例方法,死在下面while true;一直在run方法中循环没有退出.
        thread.start();    //   启动的子线程和主线程是同时执行的

        while(true){ //主进程里的语句,可去让主进程一直循环

        }
    }
}


class Mythread extends Thread{

    public Mythread(String name) {
        super(name);
    }

    @Override
    public void run() {
 //       System.out.println(Thread.currentThread().getName());
        while(true){ //子进程的语句,可让子进程一直循环.

        }
    }
}