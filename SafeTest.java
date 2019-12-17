package lessson2;

public class SafeTest {
    private static int COUNT;
    //1.初始化一个变量值 = 0;
    //2.启动20个线程，每个线程对这个值++,
    //执行10000次
   public  static synchronized  void increment(){
       COUNT++;
   }
    public  static synchronized  void decrement(){
        COUNT--;
    }

    //    public static void increment(){  //俩种加法意义一样
//        synchronized (SafeTest.class){
//            COUNT++;
//        }
//    }

    //    public synchronized void increment2(){
//        COUNT++;
//    }
//    public void increment2(){
//        synchronized(this){
//            COUNT++;
//        }
//    }
    public static void main(String[] args) {
        Object o = new Object();

        Runnable r = new Runnable(){
            @Override
            public void run() {
                for(int j = 0; j < 10000; j++) {
//                        synchronized (o) {
//                            COUNT++;
//                        }
                    increment();
                    decrement();
                }
            }
        };

        for(int i = 0; i < 20; i++){
            new Thread(r).start();
        }

        // >1 使用debug方式启动
        while (Thread.activeCount() > 1){
            Thread.yield(); //线程让步,从运行态转变为就绪态.
            System.out.println(COUNT);
        }
    }
}
