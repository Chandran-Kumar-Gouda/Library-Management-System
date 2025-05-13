package service;

import model.Book;
import java.util.Map;

public class BookService {
    private Map<String, Book> books;

    public BookService(Map<String, Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void listBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }
}
