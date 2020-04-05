package lessonG1;

public class SynchronizedTest2 {

    private static int SUM;

    public static synchronized void test1(){
        SUM++;
    }

    public static synchronized void test2(){//计数器=1
        test1();//进入test1方法，计数器=2，退出方法/方法返回，计数器--操作，=1
        SUM++;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                test2();
            }
        }).start();
    }
}
