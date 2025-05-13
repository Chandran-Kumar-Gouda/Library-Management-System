# Library Management System

A simple console-based Library Management System that allows users to either log in as a librarian or a member. The system supports functionalities like viewing books and adding new books, as well as handling authentication for both roles.

## Features

- **User Authentication**: Users can log in as either a member or librarian.
- **Member Functionality**: Members can view the list of books available in the library.
- **Librarian Functionality**: Librarians can view, add, and manage books in the library.
- **File Persistence**: Book and user information is stored in `txt` files for persistent data management.


## Files

- **Main.java**: The main entry point for the application. It handles user authentication and displays the appropriate menu based on the user's role (MEMBER or LIBRARIAN).
- **Book.java**: Represents a book in the library, with attributes like ISBN, title, author, and copies available.
- **User.java**: Represents a user in the system (either a member or a librarian) with attributes like user ID, password, name, and user type.
- **AuthService.java**: Handles authentication of users.
- **BookService.java**: Contains the logic for viewing and managing books in the system.
- **UserDAO.java**: Data Access Object for reading and retrieving user information from `users.txt`.
- **BookDAO.java**: Data Access Object for reading and managing book data from `books.txt`.

## Data Files

### `users.txt`

Contains the credentials for users (both members and librarians). Each line follows the format:


### `books.txt`

Contains the book information available in the library. Each line follows the format:


