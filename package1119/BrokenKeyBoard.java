package package1119;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BrokenKeyBoard {
    // 先在 main 方法中写出基本的输入输出框架
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 1. 读取两个字符串
            //    expected 预期要输出的字符串 7_This_is_a_test
            //    actual 是实际输出的字符串  _hs_s_a_es
            //    核心思路是拿预期的内容去实际的内容中找
            String expected = scanner.next();
            String actual = scanner.next();
            // 2. 把两个字符串都改成大写
            expected = expected.toUpperCase();
            actual = actual.toUpperCase();
            // 3. 题目的主要任务判定 expected 中哪些字符在 actual 中不存在
            //    先搞一个 setActual 用来保存实际哪些字符输出了.
            Set<Character> setActual = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                setActual.add(actual.charAt(i));
            }
            // 这个 setPrinted 是用于最终输出结果去重的. 已经被判定为坏的键不能输出两次
            // 输出过的坏键就放到这个 set 中
            Set<Character> setPrinted = new HashSet<>();
            // 4. [核心操作!] 然后使用 expected 来遍历, 判断这个字符是否在 actual 中存在
            for (int i = 0; i < expected.length(); i++) {
                char c = expected.charAt(i);
                if (setActual.contains(c)) {
                    // 如果当前字符已经实际输出了, 说明是好的键
                    continue;
                }
                // 如果当前字符 c 没有实际输出, 说明是坏的键
                // 但是坏的键要看看之前是不是输出过, 如果曾经输出过, 也就不必输出
                if (setPrinted.contains(c)) {
                    // 这是 c 曾经输出过
                    continue;
                }
                // 注意, 不要输出换行
                System.out.print(c);
                setPrinted.add(c);
            }  // end for
        }  // end while (scanner.hasNext())
    }  // end main
}
