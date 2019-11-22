package com.BookManagementSystem.Book;

public class BookList {
    private Book[] books = new Book[100];
    private int size;

    public BookList(){  //存几本书
        books[0] = new Book("三国演义",
            "罗贯中", 001, "100", "古代名著", false);
        books[1] = new Book("金瓶梅",
                "兰陵笑笑生", 002, "200",
                "古典名著", false);
        books[2] = new Book("水浒传",
                "施耐庵", 003, "100",
                "古典名著", false);
        books[3] = new Book("西游记",
                "吴承恩", 004, "200",
                "古典名著", false);
        this.size = 4;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setBook(int index, Book book){
        books[index] = book;
    }
    public Book getBook(int index){
        return books[index];
    }
}
