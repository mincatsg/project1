package lesson3;

public class VolatileTest {

    public static volatile int N;

    public static synchronized  void increment(){
        //1.从主内存中获取N
        //2.N = N + 1
        //3.把N写会内存
        N++;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 100; j++){
//                           increment();  等价于下面那个代码
                        synchronized (VolatileTest.class){
                            N++;
                        }
                        if(N == 100){
                            System.out.println("=====" +N);
                        }
                    }
                }
            }).start();
        }

        while(Thread.activeCount() > 1){
            Thread.yield();
       }
        System.out.println(N);
    }
}
