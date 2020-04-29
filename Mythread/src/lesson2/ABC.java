package lesson2;

public class ABC {

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println('A');
            }
        });
        a.start();
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.join();  //线程等待
                    System.out.println('B');
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        b.start();
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.join();
                    System.out.println('C');
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        c.start();
    }
}
