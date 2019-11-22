package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.Book;
import com.BookManagementSystem.Book.BookList;

import java.util.Scanner;

public class DeleteOperation implements IOperation {
    @Override
    public void work(BookList booklist){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要删除的书籍名字");
        String name = scanner.next();
        int size;
        for(size = 0; size < booklist.getSize(); size++){
            Book book  = booklist.getBook(size);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(size >= booklist.getSize()){
            System.out.println("无这本书,无法删除");
        }else{
            Book lastBook = booklist.getBook(booklist.getSize() - 1);
            booklist.setBook(size, lastBook);
            booklist.setSize(booklist.getSize() - 1);
            System.out.println("删除成功!");
        }
    }
}
