package package1104;

public class Test {
    // 编译器优化
    public static void main(String[] args) {
        String str2 = "360";
        String str = "hello " + "world" + str2;
        // 创建了几个 String 对象
        // 编译器优化是和编译器实现强相关的.
    }
}
