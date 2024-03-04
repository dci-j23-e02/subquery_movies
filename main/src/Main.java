package src;

public class Main {
  public static void main(String[] args) {
    MovieDao movieDao = new MovieDaoImpl();

    System.out.println("Movies with actor 'Tom Hanks':");
    movieDao.findMoviesWithActor("Tom Hanks").forEach(System.out::println);

    System.out.println("\nActors in 'Drama' genre:");
    movieDao.findActorsInGenre("Drama").forEach(System.out::println);

    System.out.println("\nActors for movies not in year 2000:");
    movieDao.findActorsForMoviesNotInYear(2000).forEach(System.out::println);
  }
}