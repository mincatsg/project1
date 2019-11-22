package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.Book;
import com.BookManagementSystem.Book.BookList;

public class PrintAllOperation  implements IOperation{
    @Override
    public void work(BookList booklist){
        for(int size = 0; size < booklist.getSize(); size++){
            Book book = booklist.getBook(size);
            System.out.println(book);
        }
        System.out.println("共计 " + booklist.getSize() + " 本书!");
    }
}
