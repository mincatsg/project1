package lesson5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor executor
                = new ThreadPoolExecutor(1,1,0L,
                          TimeUnit.SECONDS, new ArrayBlockingQueue(Integer.MAX_VALUE),new ThreadPoolExecutor.AbortPolicy());



    }
}
