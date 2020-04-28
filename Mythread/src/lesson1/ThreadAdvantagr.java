package lesson1;

public class ThreadAdvantagr {

    public static final long NUM = 1000000000L;
 //不是线程越多越好,一般使用CPU的核数

    //多线程提高效率,也是和线程数,任务量有关系的
 //使用多少线程,和硬件资源有关,达到峰值一般推荐为CPU的核数.
    public static void serial(){
        for(int i = 0; i < NUM; i++){
            i++;
        }
    }


    public static void parallel(){
        for(int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                     serial();;
                }
            }).start();
        }
    }

    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();
        serial();
        serial();
        long end1 =  System.currentTimeMillis();
        System.out.println("串行: " +(end1 - start1) + "毫秒");


        long start2 = System.currentTimeMillis();
        parallel();
        while(Thread.activeCount() > 1)
            Thread.yield();
        long end2 =  System.currentTimeMillis();
        System.out.println("并行: " +(end2 - start2) + "毫秒");
    }
}
