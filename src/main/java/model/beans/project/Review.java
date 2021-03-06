package model.beans.project;

public class Review {

    private int id;
    private int rating;
    private String description;
    private String bookName;
    private int bookID;

    public Review() {
        id = 0;
        rating = 0;
        description = "";
        bookID = 0;
    }

    public Review(int id, int rating, String description, String bookName, int bookID) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.bookName = bookName;
        this.bookID = bookID;
    }

    public Review(int rating, String description, String bookName, int bookID) {
        this.rating = rating;
        this.description = description;
        this.bookName = bookName;
        this.bookID = bookID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
