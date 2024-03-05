package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    MovieDao movieDao = new MovieDaoImpl();

//    System.out.println("Movies with actor 'Jenny Doe.':");
//    movieDao.findMoviesWithActor("Jenny Doe.").forEach(System.out::println);
//
//   System.out.println("\nActors in 'Drama' genre:");
//   movieDao.findActorsInGenre("Drama").forEach(System.out::println);
//
//   System.out.println("\nActors for movies not in year 2000:");
//   movieDao.findActorsForMoviesNotInYear(2000).forEach(System.out::println);
//    System.out.println("ACTORS BY MOVIE RELEASE YEARS 2024, 2005,2019");
//    movieDao.findActorsByMovieReleaseYears(List.of( 2024, 2005,2019)).forEach(System.out::println);
//    List<String> actors = movieDao.findActorsByMovieReleaseYears(List.of(2020,2005,1994));
//    for (String actor : actors) {
//      System.out.println(actor);
//    }

    System.out.println("Find movies newer than All Drama movies");
    movieDao.findMoviesNewerThanGenre("Drama").forEach(System.out::println);

  }
}