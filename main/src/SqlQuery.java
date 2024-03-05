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
  ),
  FIND_ACTORS_BY_MOVIE_RELEASE_YEARS(
      "SELECT DISTINCT a.name FROM actors a"
          + " WHERE a.movie_id = ANY("
          + "    SELECT id FROM moviestable"
          + "    WHERE release_year = ANY(ARRAY[?])"
          + "    )"
  ),
  FIND_MOVIES_NEWER_THAN_ALL_GENRE(
      "SELECT * FROM moviestable "
          + " WHERE release_year > ALL("
          + "    SELECT  release_year FROM moviestable WHERE genre = ? "
          + "    );"
  );

  public final String query;

  SqlQuery(String query) {
    this.query = query;
  }

}
