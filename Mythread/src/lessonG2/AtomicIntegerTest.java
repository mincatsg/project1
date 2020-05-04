package lessonG2;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private static AtomicInteger AI = new AtomicInteger();

    public static void main(String[] args) {
        for(int i=0; i<20; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        AI.incrementAndGet();//++n
//                        AI.getAndIncrement();//n++
                    }
                }
            }).start();
        }
        while (Thread.activeCount()>1)
            Thread.yield();
        System.out.println(AI.get());
    }
}
