package com.BookManagementSystem.user;

import com.BookManagementSystem.operation.*;

import java.util.Scanner;
public class Admin extends User{
    public Admin(String name) {
        super(name);
        iopreation = new IOperation[]{
                new FindOperation(),
                new AddOperation(),
                new DeleteOperation(),
                new PrintAllOperation(),
                new ExitOperation()
        };
    }
    @Override
    public int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("Hello!" +   this.name);
        System.out.println("1.查找书籍");
        System.out.println("2.添加书籍");
        System.out.println("3,删除书籍");
        System.out.println("4.打印所有书籍信息");
        System.out.println("5.退出");
        System.out.println("===============================");
        System.out.print("你的选择是: ");
        int choice = scanner.nextInt();
        System.out.println();
        return choice;
    }
}
