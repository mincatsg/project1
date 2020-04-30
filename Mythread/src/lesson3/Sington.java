package lesson3;

public class Sington {

        private static Sington instance = null;
    private Sington() {}
        public static Sington getInstance() {
            if (instance == null) {
                //1.分配内存空间
                //2.初始化对象
                //3.把这个对象赋值给变量引用
                //执行指令重排序：132
                instance = new Sington();
            }
            return instance;
        }
    public static void main(String[] args) {
               for(int i = 0; i < 10; i++){
                   new Thread(new Runnable() {
                       @Override
                       public void run() {
                           Sington s = Sington.getInstance();
                       }
                   }).start();
               }
    }
}
