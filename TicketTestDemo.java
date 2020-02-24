package lesson3;

class MyThread implements Runnable {
    private int ticket = 1000 ; // 一共十张票
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
// 在同一时刻，只允许一个线程进入代码块处理
            synchronized(this) { // 表示为程序逻辑上锁
                if(this.ticket>0) { // 还有票
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(Thread.currentThread().getName()+",还有" +this.ticket
                            -- +" 张票");
                }
            }
        }
    }
}
   public class TicketTestDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t1 = new Thread(mt,"黄牛A");
        Thread t2 = new Thread(mt,"黄牛B");
        Thread t3 = new Thread(mt,"黄牛C");
        t1.start();
        t2.start();
        t3.start();
    }
}
