/**
 * Nicholas Dhannie
 * CEN 3024C - Software Development 1
 * January 19, 2024
 * FileHandling.java
 * This class is what will be about saving and loading the file named Books to the LBMS.
 */

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileHandling {

    //This is to save the text file to the desktop
    private static final String FILE_PATH = System.getProperty("user.home") + "\\Desktop\\books.txt";

    /**
     * Name: saveBooksFile
     * @param books
     *
     * This will save Book objects to the file of books.txt
     * It will save it in the format that was specified in
     * the requirements and each book will be written omn a new line.
     *
     */
    public static void saveBooksFile(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getBookTitle() + "," + book.getBookAuthor());
                writer.newLine();
            }
            System.out.println("Books saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    /**
     * Name: loadBooksFile
     * @param books
     *
     * This will load the book file and read the next line
     * from the list and split the added book into 3 parts.
     *
     * If you were to close the program and open it back up it
     * will be able to have the same books that were added into
     * the LBMS and not have to start over.
     */
    public static void loadBooksFile(List<Book> books) {
        try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    Book loadedBook = new Book(id, title, author);
                    books.add(loadedBook);
              }
            }
            System.out.println("Books loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
