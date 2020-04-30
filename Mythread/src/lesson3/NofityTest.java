package lesson3;

public class NofityTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //对NofityTest.class对象加锁
                synchronized (NofityTest.class){
                    try {
                        System.out.println("t1");
                        //t1线程阻塞,释放NofityTest.class对象的锁
                        NofityTest.class.wait();
                        System.out.println("t1 wait finish");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        //竞争NofityTest.class对象锁
                        synchronized (NofityTest.class) {
                            //通知NofityTest.class对象
                            // 所有竞争该对象锁的线程来竞争
                            //通知是在synchronized代码快退出以后再通知NofityTest.class.wait()
                            //ynchronized(NofityTest.class)阻塞的
                            //线程都可以来竞争了.
                            NofityTest.class.notify();
                            System.out.println("t2");
                            Thread.sleep(1000);
                            System.out.println("t2 wait finish");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        t2.start();
    }
}
