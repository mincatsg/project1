package lessonG1;

public class SynchronizedTest {

    private static int SUM;

    public static void main(String[] args) {//javap把当前类反编译看看字节码
//        for(int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (SynchronizedTest.class){
                        SUM++;//一条指令分解为三条指令：1.从主内存读取SUM 2.修改为SUM+1 3.写回主内存
                    }
                }
            }).start();
//        }
    }

    private static volatile SynchronizedTest TEST;
    public SynchronizedTest(){}
    public static SynchronizedTest getInstance(){
        if(TEST == null){
            synchronized (SynchronizedTest.class){
                if(TEST == null){
                    TEST = new SynchronizedTest();
                    // new对象分解为三条指令：
                    //1.分配内存空间
                    //2.初始化对象
                    //3.把对象赋值给变量
                }
            }
        }
        return TEST;
    }
}
