package src;

public enum SqlQuery {
  FIND_MOVIES_WITH_ACTOR(
      "SELECT * FROM moviestable WHERE EXISTS"
      + "(SELECT 1 FROM actors WHERE actors.movie_id = moviestable.id AND actors.name = ?)"
  ),
  FIND_ACTORS_IN_GENRE(
      "SELECT name FROM actors WHERE movie_id IN "
          + "(SELECT id FROM moviestable WHERE genre=?)"
  ),
  FIND_ACTORS_FOR_MOVIES_NOT_IN_YEAR(
      "SELECT name FROM actors WHERE movie_id NOT IN"
        +"(SELECT id FROM moviestable WHERE release_year < ?)"
  );

  public final String query;

  SqlQuery(String query) {
    this.query = query;
  }
}
