package com.BookManagementSystem.user;

import com.BookManagementSystem.operation.*;

import java.util.Scanner;

public class OrdinaryUser extends User{

    public OrdinaryUser(String name) {
        super(name);
        iopreation = new IOperation[]{
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new PrintAllOperation(),
                new ExitOperation()
        };
    }

    @Override
    public int menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println("Hello!" +    this.name);
        System.out.println("1.查找书籍");
        System.out.println("2.借阅书籍");
        System.out.println("3,归还书籍");
        System.out.println("4.打印书籍信息");
        System.out.println("5.退出");
        System.out.println("===============================");
        System.out.print("你的选择是: ");
        int choice = scanner.nextInt();
        System.out.println();
        return choice;
    }

}
