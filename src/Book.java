/**
 * Nicholas Dhannie
 * CEN 3024C - Software Development 1
 * January 19, 2024
 * Book.java
 * This class is what will be about the Book object.
 */

public class Book {
    private int id;
    private String bookTitle;
    private String bookAuthor;

    /**
     * Name: Book
     * @param id
     * @param bookTitle
     * @param bookAuthor
     * This will allow for a book to be created
     * by having the: id, bookTitle, bookAuthor
     */
    public Book(int id, String bookTitle, String bookAuthor) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    /**
     * name: setId
     * @param id
     * This is to set the Id of the book,
     * and to also make sure that the id
     * is a positive number. If it is not then
     * it will send a message.
     */
    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        } else {
            // Handling an invalid ID. Message will be displayed to let user know what is wrong.
            System.out.println("Invalid ID provided. ID cannot be a negative value.");
        }
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }


    /**
     * Name: toString
     *
     * This is to make sure that when the user is
     * selecting the option to list all the books
     * it will display in the terminal
     * to obtain the string representation of the object.
     *
     */
    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + bookTitle + ", Author: " + bookAuthor;
    }
}
