import service.AuthService;
import service.BookService;
import model.User;
import model.Book;
import java.util.*;

public class Main {
    private static AuthService authService;
    private static BookService bookService;

    public static void main(String[] args) {
        // Initialize services
        authService = new AuthService();
        bookService = new BookService();

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("== Library System ==");

        // Login Process
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Authenticate user
        User user = authService.authenticate(userId, password);
        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }

        System.out.println("Welcome " + user.getName() + " (" + user.getUserType() + ")");
        // Display options based on user type (MEMBER or LIBRARIAN)
        if (user.getUserType().equalsIgnoreCase("MEMBER")) {
            showMemberMenu(scanner);
        } else {
            showLibrarianMenu(scanner);
        }
    }

    // Menu for member
    public static void showMemberMenu(Scanner scanner) {
        while (true) {
            System.out.println("1. View Books");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    bookService.viewBooks();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Menu for librarian
    private static void showLibrarianMenu(Scanner scanner) {
        while (true) {
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    showBooks();
                    break;
                case 2:
                    addBook(scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Display books for librarian and member
    private static void showBooks() {
        List<Book> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book.getIsbn() + " - " + book.getTitle() + " by " + book.getAuthor() + " (" + book.getCopiesAvailable() + " copies)");
            }
        }
    }

    // Add a new book for librarian
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
        
        Book newBook = new Book(isbn, title, author, copies);
        bookService.addBook(newBook); // Add to database
        System.out.println("Book added successfully.");
    }
}
