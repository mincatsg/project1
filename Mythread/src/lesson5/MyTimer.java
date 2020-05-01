package lesson5;

public class MyTimer {

    public void schedule(Runnable task, long delay, long period){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

  public static class MyTimerTask{
        private long next;

  }
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("mytimer");
            }
        },0,1000);
    }
}
