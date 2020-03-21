package test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class TestGson {
    static class Test {
        private int aaa;
        private int bbb;
    }

    public static void main(String[] args) {
        // 1. 先创建一个 Gson 对象
        Gson gson = new GsonBuilder().create();

        // 2. 把键值对数据转成 JSON 格式的字符串
        // 表示一个英雄相关信息
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("name", "曹操");
//        hashMap.put("skill1", "三段跳");
//        hashMap.put("skill2", "剑气");
//        hashMap.put("skill3", "加攻击并吸血");
//        hashMap.put("skill4", "每次释放技能都加攻速");
//        String result = gson.toJson(hashMap);
//        System.out.println(result);

        // 3. 把JSON格式字符串转成键值对数据
        String jsonString = "{ \"aaa\": 1, \"bbb\":2 }";
        // Test.class 取出当前这个类的类对象
        // fromJson 方法实现, 依赖 反射 机制.
        // fromJson 实现过程, 通过 Test.class 就知道 Test 类中存在两个字段, 一个是 aaa(int), bbb(int).
        // 解析字符串内容, 取到 json 字符串中 key 为 aaa 的值, 把这个值填充到 Test 的 aaa 属性中;
        Test t = gson.fromJson(jsonString, Test.class);
        System.out.println(t.aaa);
        System.out.println(t.bbb);
    }
}

