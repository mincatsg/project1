package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.Book;
import com.BookManagementSystem.Book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList booklist){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要归还的书籍编号");
        int id = scanner.nextInt();
        int size;
        for(size = 0; size < booklist.getSize(); size++){
            Book book  = booklist.getBook(size);
            if(book.getId() == id){
                book.setBorrowed(false);
                System.out.println("归还成功");
                break;
            }
        }
    }
}
