package src;

public enum SqlQuery {
  FIND_MOVIES_WITH_ACTOR("SELECT * FROM moviestable WHERE EXISTS(SELECT 1 FROM actors WHERE actors.movie_id = moviestable.id AND actors.name = ?)");

  public final String query;

  SqlQuery(String query) {
    this.query = query;
  }
}
