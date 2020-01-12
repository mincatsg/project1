import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClonableTest {

    @Test
    public void t1() throws CloneNotSupportedException {
        Person1 old = new Person1("张三", 11);
        Person1 clone = (Person1) old.clone();
        old.age = 12;
        System.out.println("old="+old);
        System.out.println("clone="+clone);
    }

    @Test
    public void t2() throws CloneNotSupportedException {
        Person1 old1 = new Person1("张三", 11);
        Person1 old2 = new Person1("李四", 12);
        Person1Container container = new Person1Container();
        container.name = "abc";
        //添加到一个list中
        container.person1s.add(old1);
        container.person1s.add(old2);
        Person1Container clone = (Person1Container) container.clone();
        //张三的年龄修改为13
        container.name = "efg";
        container.person1s.get(0).age = 13;
        System.out.println(container.name+"\n"+container.person1s);
        //clone.person1s是复制的container.person1s的引用
        System.out.println(clone.name+"\n"+clone.person1s);
    }

    public static class Person1Container implements Cloneable{
        private String name;
        private List<Person1> person1s = new ArrayList<>();

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    /**
     * 浅拷贝：包括实现Cloneable接口，System.arrayCopy()都是浅拷贝
     * 浅拷贝不能对复杂对象的属性进行真实拷贝，具体是指将引用拷贝过去的
     */
    public static class Person1 implements Cloneable{
        private String name;
        private Integer age;

        public Person1(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
