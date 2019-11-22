package com.BookManagementSystem.operation;

import com.BookManagementSystem.Book.BookList;

public class ExitOperation implements IOperation{
        @Override
        public void work(BookList booklist){
                System.out.println("goodbye!");
                System.exit(0);
        }
}
