package jvm3;

/**
 * JVM参数如下:(使用Serial+Serial Old收集器组合)
 * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * 堆：20m，年輕代/老年代：10m，Eden：8m，每個survivor區：1m
 *
 * @author 38134
 */
public class Test1 {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
// 出现Minor GC
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws Exception {
        testAllocation();
    }
}