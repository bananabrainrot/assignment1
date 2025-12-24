import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        int choice = -1;

        while (choice != 7) {
            System.out.println("\n--- Welcome to Library App! ---");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1 -> printAllBooks();
                case 2 -> addBook();
                case 3 -> searchByTitle();
                case 4 -> borrowBook();
                case 5 -> returnBook();
                case 6 -> deleteBook();
                case 7 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    private void addBook() {
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine());

            books.add(new Book(title, author, year));
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void searchByTitle() {
        System.out.print("Enter title part: ");
        String part = scanner.nextLine().toLowerCase();
        boolean found = false;

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(part)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No matching books found.");
    }

    private void borrowBook() {
        System.out.print("Enter book ID to borrow: ");
        int id = scanner.nextInt();
        for (Book b : books) {
            if (b.getId() == id) {
                if (b.isAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("You borrowed the book.");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();
        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.isAvailable()) {
                    b.markAsReturned();
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void deleteBook() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = books.removeIf(b -> b.getId() == id);
        if (removed) {
            System.out.println("Book deleted.");
        } else {
            System.out.println("Error: Book not found.");
        }
    }

    public static void main(String[] args) {
        new LibraryApp().run();
    }
}
