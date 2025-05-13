package service;

import model.Book;

public class TransactionService {
    public void issueBook(Book book) {
        if (book.getCopies() > 0) {
            book.setCopies(book.getCopies() - 1);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(Book book) {
        book.setCopies(book.getCopies() + 1);
        System.out.println("Book returned successfully.");
    }
}
