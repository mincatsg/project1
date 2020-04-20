package reflect;

import frank.ioc.Duck;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //   Class<Duck> clazz = Duck.class;
        Class<?> clazz = Class.forName("frank.ioc.Duck");

        //通过类对象,生成对象的实例: 通过构造方法生成
        //无参数构造方法创建
        Duck duck = (Duck) clazz.newInstance();
        System.out.println(duck);

        //有参数构造方法创建

        Duck duck2 = (Duck) clazz.getConstructor(String.class, Integer.class).newInstance("小黄鸭", 12);
        System.out.println(duck2);

        //获取类的属性+对象的属性
        Field[] fields = Duck.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + "=" + field.get(duck2));
        }


        //通过对象调用方法
        Method method = Duck.class.getDeclaredMethod("setAge", Integer.class);
        method.invoke(duck2, 3); //类似duck2.setAge(3)方法调用;
        System.out.println(duck2);


    }


}
