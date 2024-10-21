package br.moviespoo;

public class Movie {
    private int id;
    private String title;
    private String director;
    private String year;
    private String genre;
    private double rating;
    private double duration;

    // No-argument constructor -> now i can initialize objects without all parameters !
    public Movie() {
        this.id = 0; // Default values
        this.title = "";
        this.director = "";
        this.genre = "";
        this.year = "";
        this.rating = 0.0;
        this.duration = 0.0;
    }

    //PARAMETRIZED CONSTRUCTOR
    public Movie(int id, String title, String director, String year, String genre, double rating, double duration) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
    }

    //GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // toString method to return a full description of the movie
    @Override
    public String toString() {
        return "Movie Details:\n" +
                "ID: " + id + "\n" +
                "Title: " + title + "\n" +
                "Director: " + director + "\n" +
                "Genre: " + genre + "\n" +
                "Release Year: " + year + "\n" +
                "Rating: " + rating + "\n" +
                "Duration: " + duration + " minutes";
    }



}
