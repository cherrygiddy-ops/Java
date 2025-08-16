package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    private static List<Movie>movies = List.of(
            new Movie("b",6,Genre.ACTION),
            new Movie("a",15,Genre.ACTION),
            new Movie("c",25,Genre.DRAMA)
    );


    public static void show(){
    groupByCollection();
    }

    private static void countMovieswithMoreThanLikes(int likes) {

        movies.stream()
                //.map(Movie::getTitle)
                .filter(movie ->movie.getTitle().contains("a"))
                .skip(2)
                .limit(10)
                .forEach(System.out::println);
    }
    public static void generateRandomInfiniteNumbers(){
        Stream.generate(Math::random)
                .limit(20)
                .forEach(System.out::println);
    }
    public static void sortBYTitle(){
        movies.stream()
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(System.out::println);

    }
    public static void sortBYLikes(){
        movies.stream()
                .sorted(Comparator.comparing(Movie::getLikes).reversed())
                .forEach(System.out::println);

    }
    public static void getMax(){
       var movie= movies.stream()
                .min(Comparator.comparingInt(Movie::getLikes))
                .get();
        System.out.println(movie);


    }
    public static void getTotalLikes(){
        var totalLikes= movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum)
                .get();
        System.out.println(totalLikes);
    }
    public static void usingCollectors(){
        var movie= movies.stream()
                .filter(movie1 -> movie1.getLikes()>10)
                .map(movie1 -> movie1.getTitle())
                .collect(Collectors.joining(","));
        System.out.println(movie);


    }
    public static void groupByCollection(){
        var movie= movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,Collectors.counting()));
        System.out.println(movie);


    }
}
