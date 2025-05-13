package dao;

import model.Book;
import java.io.*;
import java.util.*;

public class BookDAO {
    private static final String BOOK_FILE = "data/books.txt";

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[3])));
            }
        } catch (IOException e) {
            System.out.println("Error reading books.");
            e.printStackTrace();
        }
        return books;
    }

    public void updateBookCopies(String isbn, int copies) {
        List<Book> books = getBooks();
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setCopiesAvailable(copies);
                break;
            }
        }
        writeBooksToFile(books);
    }

    private void writeBooksToFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                writer.write(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getCopiesAvailable() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing books.");
            e.printStackTrace();
        }
    }
}
