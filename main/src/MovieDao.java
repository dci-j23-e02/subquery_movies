package src;

import java.util.List;

public interface MovieDao {
  List<Movie> findMoviesWithActor(String actorName);
  List<String> findActorsInGenre(String genre);
  List<String> findActorsForMoviesNotInYear(int year);
  List<String> findActorsByMovieReleaseYears(List<Integer> years);
  List<Movie> findMoviesNewerThanGenre(String genre);
}