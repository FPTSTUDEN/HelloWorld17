package e2_3;
import java.util.ArrayList;

// Book.java
public class Book {
    private String title;
    private String author;
    private int year;
    private double rating;
    private ArrayList<String> reviews = new ArrayList<>();

    // Constructor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public double getRating() { return rating; }
    public ArrayList<String> getReviews() { return reviews; }

    // Task 4: Ratings and Reviews
    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + year;
    }
}
