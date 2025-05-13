package service;

import dao.BookDAO;
import model.Book;
import java.util.List;

public class BookService {
    private BookDAO bookDAO = new BookDAO();

    public void viewBooks() {
        List<Book> books = bookDAO.getBooks();
        for (Book book : books) {
            System.out.println(book.getIsbn() + " - " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getCopiesAvailable() + " copies)");
        }
    }

    public List<Book> getAllBooks() {
        return bookDAO.getBooks();
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }
}
