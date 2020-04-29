package lesson2;

public class FlagStopTest {
    public static volatile boolean Is_Interrupted = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(!Is_Interrupted){
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread.sleep(3000);
        Is_Interrupted = true;
    }
}
