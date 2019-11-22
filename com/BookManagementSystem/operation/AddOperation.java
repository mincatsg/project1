package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.Book;
import com.BookManagementSystem.Book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList booklist){
        System.out.println("新增一本书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名:");
        String name = scanner.next();
        System.out.println("请输入序号:");
        int id = scanner.nextInt();
        System.out.println("请输入作者: ");
        String author = scanner.next();
        System.out.println("请输入价格:");
        String price = scanner.next();
        System.out.println("请输入类别: ");
        String type = scanner.next();
        Book book = new Book(name,author,id,price,type,false);
        booklist.setBook(booklist.getSize(), book);
        booklist.setSize(booklist.getSize() + 1);
        System.out.println("添加成功");
    }
}
