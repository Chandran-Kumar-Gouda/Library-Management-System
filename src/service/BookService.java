package service;

import model.Book;
import dao.BookDAO;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService() {
        bookDAO = new BookDAO();
    }

    public List<Book> getAllBooks() {
        return bookDAO.getBooks();
    }

    public void updateBookCopies(String isbn, int copies) {
        bookDAO.updateBookCopies(isbn, copies);
    }
}
