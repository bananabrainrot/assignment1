import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }

    public void run() {
        while (true) {
            System.out.println("\nLibrary Menu");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Choose from 1 to 7");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printAllBooks();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    searchBooksByTitle();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBookById();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library"); // [cite: 81]
        } else {
            for (Book b : books) {
                System.out.println(b.toString()); // [cite: 82]
            }
        }
    }

    public void addNewBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        Book newBook = new Book(title, author, year);
        books.add(newBook);
        System.out.println("Book added!");
    }

    public void searchBooksByTitle() {
        System.out.print("Enter part of title: ");
        String search = scanner.nextLine().toLowerCase();

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(search)) {
                System.out.println(b);
            }
        }
    }

    public void borrowBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("You borrowed: " + b.getTitle());
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();

        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isAvailable()) {
                    b.markAsReturned();
                    System.out.println("You returned: " + b.getTitle());
                } else {
                      System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBookById() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();

        Book bookToDelete = null;

        for (Book b : books) {
            if (b.getId() == id) {
                bookToDelete = b;
                break;
            }
        }

        if (bookToDelete != null) {
            books.remove(bookToDelete);
            System.out.println("Book deleted.");
        } else {
            System.out.println("not found.");
        }
    }
}