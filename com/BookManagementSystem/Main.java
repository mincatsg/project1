package com.BookManagementSystem;

import com.BookManagementSystem.Book.BookList;
import com.BookManagementSystem.user.Admin;
import com.BookManagementSystem.user.OrdinaryUser;
import com.BookManagementSystem.user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while(true){
            int choice =  user.menu();
            user.doOperation(choice - 1,bookList);
        }
    }
    public static User login(){
        System.out.println("===============");
        System.out.println("1.管理员");
        System.out.println("2.普通用户");
        System.out.println("===============");
        System.out.print("请输出你的权限: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println();
        if(choice == 1){
            return  new Admin("小明");
        }
        return new OrdinaryUser("明明");
    }
}
