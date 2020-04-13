package jvm3;

/**
 * JVM参数如下:
 * 第一次执行设置MaxTenuringThreshold=1,第二次设置MaxTenuringThreshold=15
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms200M -Xmx200M -Xmn24M -XX:SurvivorRatio=1 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * 堆：200m，老年代：40m，新生代：50m，eden：8m，survivor：8m
 *
 * @author 38134
 */
public class Test3 {
    private static final int _1MB = 1024 * 1024;

    @SuppressWarnings("unused")
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3;
        //保存在Eden区
        allocation1 = new byte[_1MB / 4];
// 什么时候进入老年代取决于XX:MaxTenuringThreshold的设置
        //保存在Eden区
        allocation2 = new byte[4 * _1MB];
        //Eden区8m存放不了前三个对象，发生minor gc：1和2回收放到survivor区，3放到回收后的eden区
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        //eden8m，3和4存放就满了，发生minor gc：1和2的年纪超过最大值1，将晋升到老年代，
        // 3没有引用指向了，直接回收，回收后新生代就是空的。
        // 再次创建的对象放在eden区
        allocation3 = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}