package lesson2;

public class Interrupt {

    public static void explain() {

        Thread t = new Thread();  //IS_INTERRUPTED = false;

        //return  IS_INTERRUPTED;  IS_INTERRUPTED = false;
        boolean interrupted = Thread.interrupted();

        //interrupt()
        //1.IS_INTERRUPTED = true;
        //2.如果线程处于调用wait()，join()，sleep()造成阻塞状态,就直接抛出InterruptedException异常
        //3.抛出异常后,IS_INTERRUPTED = true;
        //Thread.currentThread().interrupt();  直接中断,不用管咋中断.
        t.interrupt();

        //return IS_INTERRUPTED;
        //Thread.currentThread().isInterrupted();
        t.isInterrupted();
    }

    public static void ignoreInterrupt() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //isInterrupted = false;
                //->main()没有sleep修改为true;
                while (!Thread.currentThread().isInterrupted()) {
                    //->main()有sleep修改为true
                    try {
                        System.out.println(Thread.currentThread().getName());
                        //抛出异常
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //isInterrupted = false;
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        Thread.sleep(3000);
        t.interrupt();

    }

    public static void interruptQuit() throws InterruptedException {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //isInterrupted = false;
                //->main()没有sleep修改为true;
                //->main()有sleep修改为true
                try {
                    while (!Thread.interrupted()) {
                        System.out.println(Thread.currentThread().getName());
                        //抛出异常
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    //isInterrupted = false;
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        Thread.sleep(3000);
        t2.interrupt();
    }

    public static void main(String[] args) throws InterruptedException{
       ignoreInterrupt();
     //  interruptQuit();

    }
}
