package frank.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //加载Spring的配置文件,初始化上下文,生成Bean对象。。。
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");
   //     通过名字获取Bean对象
        Object o = context.getBean("myName");
        System.out.println(o.getClass());
        System.out.println(o);

//        Object o = context.getBean("duck");
//        System.out.println(o.getClass());
//        System.out.println(o);

//        Object o = context.getBean("duck1");
//        System.out.println(o.getClass());
//        System.out.println(o);
//
//        Object o1 = context.getBean("duck2");
//        System.out.println(o1.getClass());
//        System.out.println(o1);
//
//        Object o2 = context.getBean("duckShop");
//        System.out.println(o2.getClass());
//        System.out.println(o2);

//        通过类型来获取对象: 容器中只能有一个该类型的对象
//        Object duckshop = context.getBean(Duck.class);
//        System.out.println(duckshop.getClass());
//        System.out.println(duckshop);
//
//        //存在俩只鸭子,通过类型获取Bean,直接抛出异常.
//        Object duck1 = context.getBean(Duck.class);
//        System.out.println(duckshop.getClass());
//        System.out.println(duckshop);
    }
}
