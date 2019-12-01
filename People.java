public class People {
    private String name;
    private String sex;
    private int age;

    public People(String name, String sex, int age) {
        this(name);
        this.sex = sex;
        this.age = age;
    }

    public People(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        People xiaohua = new People("小花");
        System.out.println(xiaohua.name);
    }
}
