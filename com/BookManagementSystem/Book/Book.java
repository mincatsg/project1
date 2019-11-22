package com.BookManagementSystem.Book;

public class Book {
    private String name;
    private String author;
    private int id;
    private String price;
    private String type;
    private boolean isBorrowed;

    public Book(String name, String author, int id, String price, String tyoe, boolean isBorrowed) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.price = price;
        this.type = tyoe;
        this.isBorrowed = isBorrowed;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
