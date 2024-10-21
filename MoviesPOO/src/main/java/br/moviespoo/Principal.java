package br.moviespoo;

public class Principal {
    public static void main(String[] args) {
        Movie movie1 = new Movie();

        //using the constructor without all parameters !
        movie1.setTitle("Star Wars: Return of the Jedi");
        //System.out.println(movie1.getTitle());
        System.out.println(movie1.toString());

        //initializing an object movie with all the parameters expected in the parametrized constructor
        Movie movie2 = new Movie(1, "Juno", "Jason Reitman", "Comedy/Drama", "2007", 7.4, 96);
        System.out.println(movie2.toString());


    }
}