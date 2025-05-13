import model.*;
import service.*;
import dao.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = UserDAO.loadUsers("data/users.txt");
        Map<String, Book> books = BookDAO.loadBooks("data/books.txt");

        AuthService authService = new AuthService(users);
        BookService bookService = new BookService(books);
        TransactionService transactionService = new TransactionService();

        Scanner sc = new Scanner(System.in);

        System.out.println("== Library System ==");
        System.out.print("User ID: ");
        String id = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = authService.login(id, password);

        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Welcome " + user.getName() + " (" + user.getRole() + ")");

        if (user instanceof Librarian) {
            while (true) {
                System.out.println("\n1. List Books\n2. Add Book\n3. Exit");
                String choice = sc.nextLine();
                if (choice.equals("1")) {
                    bookService.listBooks();
                } else if (choice.equals("2")) {
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = Integer.parseInt(sc.nextLine());
                    bookService.addBook(new Book(isbn, title, author, copies));
                    System.out.println("Book added.");
                } else {
                    break;
                }
            }
        } else if (user instanceof Member) {
            while (true) {
                System.out.println("\n1. View Books\n2. Issue Book\n3. Return Book\n4. Exit");
                String choice = sc.nextLine();
                if (choice.equals("1")) {
                    bookService.listBooks();
                } else if (choice.equals("2")) {
                    System.out.print("Enter ISBN to issue: ");
                    String isbn = sc.nextLine();
                    Book book = bookService.getBookByIsbn(isbn);
                    if (book != null) transactionService.issueBook(book);
                } else if (choice.equals("3")) {
                    System.out.print("Enter ISBN to return: ");
                    String isbn = sc.nextLine();
                    Book book = bookService.getBookByIsbn(isbn);
                    if (book != null) transactionService.returnBook(book);
                } else {
                    break;
                }
            }
        }
    }
}
