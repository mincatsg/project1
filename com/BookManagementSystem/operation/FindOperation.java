package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.Book;
import com.BookManagementSystem.Book.BookList;

import java.util.Scanner;

public class FindOperation  implements IOperation{
    @Override
    public void work(BookList booklist){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的书籍名字");
        String name = scanner.next();
        int size;
        for(size = 0; size < booklist.getSize(); size++){
            Book book  = booklist.getBook(size);
            if(book.getName().equals(name)){
                System.out.println("找到这本书了,他的编号为: " +book.getId());
                return;
            }
        }
            System.out.println("无这本书");
    }
}
