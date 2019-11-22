package com.BookManagementSystem.user;

import com.BookManagementSystem.Book.BookList;
import com.BookManagementSystem.operation.IOperation;

abstract public class User {
    protected String name;

    protected IOperation[] iopreation;

    public User(String name) {
        this.name = name;
    }
    abstract public int menu();
    public void doOperation(int choice, BookList books){
        iopreation[choice].work(books);
    }
}
