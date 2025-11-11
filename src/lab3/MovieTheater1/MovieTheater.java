package lab3.MovieTheater1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MovieTheater {
    private ArrayList<Movie> movies;

    public MovieTheater() {
        movies = new ArrayList<>();
    }

    public void readMovies(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String title = reader.readLine();
            String genre = reader.readLine();
            int year = Integer.parseInt(reader.readLine());
            String ratingsLine = reader.readLine();
            double avgRating = Arrays.stream(ratingsLine.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .average()
                    .orElse(0.0);
            movies.add(new Movie(title, genre, year, avgRating));
        }
        reader.close();
    }

    public void printByRatingAndTitle() {
        movies.stream().sorted(Comparator.comparing(Movie::getAvgRating)
                        .reversed()
                        .thenComparing(Movie::getTitle))
                .forEach(System.out::println);
    }

    public void printByGenreAndTitle() {
        movies.stream().sorted(Comparator.comparing(Movie::getGenre)
                        .thenComparing(Movie::getTitle))
                .forEach(System.out::println);
    }

    public void printByYearAndTitle() {
        movies.stream().sorted(Comparator.comparing(Movie::getYear)
                        .thenComparing(Movie::getTitle))
                .forEach(System.out::println);
    }
}
