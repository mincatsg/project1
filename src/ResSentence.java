import java.util.Scanner;

public class ResSentence {
    public static void main(String[] args) {
//        给定一个句子（只包含字母和空格）， 将句子中的单词位置反转，单词用空格分割, 单词之间只有一个空格，前后没有空格。
//
//        比如：
//
//        （1） “hello xiao mi”-> “mi xiao hello”

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            String[] res = scanner.next().split(" ");

            String result = "";
            for (int i = res.length - 1; i >= 0; i--) {
                result = res[i] + " ";
            }

            System.out.println(result);
        }
    }
}
