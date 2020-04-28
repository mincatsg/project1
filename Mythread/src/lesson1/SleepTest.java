package lesson1;


public class SleepTest {

    public static void main(String[] args) {
    // 日期类： 1970-01-01 00:00:00
//        Date date = new Date();
//        long current = date.getTime();
//        long c = System.currentTimeMillis();

        try {
            Thread.sleep(5000);// 作用在main线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++){
                            System.out.println(i);
                            Thread.sleep(1000);  //new出来子线程休眠
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
