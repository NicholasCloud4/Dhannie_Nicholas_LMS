/**
 * Nicholas Dhannie
 * CEN 3024C - Software Development 1
 * January 19, 2024
 * Library.java
 * This class is what the user will be runnning as the Library Management System Software.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Library {
    private final List<Book> books;

    /*
    This is the main method where the LBMS will be
    using a menu system so that the user will have the
    options to select:
    1. Add new books to the collection
    2. Remove a book from the collection using its ID number
    3. List all books currently in the collection
    0. Exit the software

    If they were to select 1: they will be prompted to enter a:
    ID, NAME, and Author

    Then be prompted back to the menu screen:
    Once they are done they will have the option to view the list 3

    Then they can also have the option to remove it by selcting option 2
    They also have the option to press 0 to exit the software.

     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Library library = new Library();

        //Starting the Library Managment System using a Menu system.
        while (true) {
            outputMenu();
            int userChoice = scan.nextInt();
            int selectedChoice = userChoice;
            switch (selectedChoice) {
                //Adding a book with: ID, Title, and Author
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = scan.nextInt();
                    System.out.print("Enter Book Title: ");
                    scan.nextLine();
                    String title = scan.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scan.nextLine();
                    Book newBook = new Book(id, title, author);
                    library.addBook(newBook);
                    System.out.println("Book Has Been Added Successfully.");
                }
                case 2 -> {
                    // Removing a book by ID
                    System.out.print("Enter book ID to remove: ");
                    int bookIdRemove = scan.nextInt();
                    library.removeBook(bookIdRemove);
                }
                case 3 ->
                    // Listing all the books that were inserted in the LBMS
                        library.listBooks();
                case 0 -> {
                    // Exiting the LBMS
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    System.exit(0);
                }
                //If user inputs a choice that is not available
                //a message: invalid will be displayed
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }


    /**
     * Name: outputMenu
     * This is what will be displayed to the user
     * when they use the Library Management System Software.
     * It will list the options that the user has to select.
     */
    public static void outputMenu() {
        System.out.println("*--------------------------------------------------*");
        System.out.println(" Welcome to the Library Management System Software ");
        System.out.println("*--------------------------------------------------*");
        System.out.println();
        System.out.println("Please select an option from below by typing in the number and press enter:");
        System.out.println("""
                1. Add new books to the collection
                2. Remove a book from the collection using its ID number
                3. List all books currently in the collection
                0. Exit the software
                """);
    }

    // This constructor will initialize all the books into
    // a list and loads it into the LBMS from the
    // "FileHandling" class
    public Library() {
        this.books = new ArrayList<>();
        FileHandling.loadBooksFile(books);
    }

    /**
     * Name: addBook
     * @param book
     * This method will add a book to the LBMS
     * it will save the book to the file that is
     * created on the users desktop names "books"
     *
     */
    public void addBook(Book book) {
        books.add(book);
        FileHandling.saveBooksFile(books);
    }

    /**
     * Name: removeBook
     * @param bookId
     * This will search for the book ID and the index that the
     * book is in and be able to remove it and also
     * save it to the file.
     *
     */
    public void removeBook(int bookId) {
        int bookToRemove = findBookId(bookId);
        if (bookToRemove != -1) {
            books.remove(bookToRemove);
            System.out.println("Book removed successfully.");
            // Save books to file after removal
            FileHandling.saveBooksFile(books);
        } else {
            System.out.println("Book not found with ID: " + bookId);
        }
    }

    /**
     * Name: findBookId
     * @param bookId
     * @return i
     * Finds the index of a book with the given book ID
     */
    private int findBookId(int bookId) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == bookId) {
                return i;
            }
        }
        return -1; // This is for when the Book is not found
    }

    /**
     * Name: listBooks
     * This will list all the books from the list
     */
    public void listBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}