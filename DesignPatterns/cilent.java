package DesignPatterns;

import java.util.Scanner;

//客户端代码,负责具体的实施
public class cilent {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Operation operation = null;
        while(true){
            System.out.println("请输出你的选择");
             int choice = in.nextInt();
             operation = LogFactors.createOperate(choice);
             System.out.println(operation.name);
        }
    }
}
