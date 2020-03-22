package test;

import java.lang.reflect.Field;

public class TestRef {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hello";

        // 先创建一个 Field 对象, value 这个名字就和 String 类中包含的 char value[] 是一致的
        Field field = String.class.getDeclaredField("value");
        // 把访问权限设为可以访问
        field.setAccessible(true);
        // 根据刚才的 field 中包含的信息, 把 str 中的 value 这个数组获取到
        // value 就是 str 内部存储 "hello" 这个内容的数组
        char[] value = (char[])field.get(str);
    }
}
