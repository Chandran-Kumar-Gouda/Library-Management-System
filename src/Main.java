import service.AuthService;
import service.BookService;
import model.User;
import model.Book;
import java.util.*;

public class Main {
    private static AuthService authService;
    private static BookService bookService;

    public static void main(String[] args) {
        authService = new AuthService();
        bookService = new BookService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("== Library System ==");

        // Login Process
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authService.authenticate(userId, password);
        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Welcome " + user.getName() + " (" + user.getUserType() + ")");
        // Display options based on user type (LIBRARIAN/MEMBER)
        if (user.getUserType().equalsIgnoreCase("MEMBER")) {
            showMemberMenu(scanner);
        } else {
            showLibrarianMenu(scanner);
        }
    }

    private static void showMemberMenu(Scanner scanner) {
        System.out.println("1. View Books");
        System.out.println("2. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showBooks();
                break;
            case 2:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void showLibrarianMenu(Scanner scanner) {
        System.out.println("1. View Books");
        System.out.println("2. Add Book");
        System.out.println("3. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showBooks();
                break;
            case 2:
                addBook(scanner);
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void showBooks() {
        List<Book> books = bookService.getAllBooks();
        for (Book book : books) {
            System.out.println(book.getIsbn() + " - " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getCopiesAvailable() + " copies)");
        }
    }

    private static void addBook(Scanner scanner) {
        scanner.nextLine(); // consume newline
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Copies Available: ");
        int copies = scanner.nextInt();
        bookService.updateBookCopies(isbn, copies); // Add to database
        System.out.println("Book added successfully.");
    }
}
