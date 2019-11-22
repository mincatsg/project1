package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.Book;
import com.BookManagementSystem.Book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList booklist){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要借阅的书籍名字");
        String name = scanner.next();
        int size;
        for(size = 0; size < booklist.getSize(); size++){
            Book book  = booklist.getBook(size);
            if(book.getName().equals(name)){
                System.out.println("找到这本书了,正在为您借阅.");
                try {
                    Thread.sleep(2000);//括号里面的5000代表5000毫秒，也就是5秒，可以该成你需要的时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(!book.isBorrowed()){
                    System.out.println("借阅成功");
                    book.setBorrowed(true);
                }else {
                    System.out.println("这本书已被借阅,sorry.");
                }
                return;
        }
    }
        System.out.println("库藏中无这本书");
    }
}
