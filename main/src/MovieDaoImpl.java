package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDaoImpl implements MovieDao {

  @Override
  public List<Movie> findMoviesWithActor(String actorName) {
    List<Movie> movies = new ArrayList<>();
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(SqlQuery.FIND_MOVIES_WITH_ACTOR.query)) {
      stmt.setString(1, actorName);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        movies.add(new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("release_year"), rs.getString("genre")));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  @Override
  public List<String> findActorsInGenre(String genre) {
    List<String> actors = new ArrayList<>();
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(SqlQuery.FIND_ACTORS_IN_GENRE.query)) {
      stmt.setString(1, genre);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        actors.add(rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actors;
  }

  @Override
  public List<String> findActorsForMoviesNotInYear(int year) {
    List<String> actors = new ArrayList<>();
    try (Connection connection = ConnectionFactory.getConnection();
        PreparedStatement stmt = connection.prepareStatement(SqlQuery.FIND_ACTORS_FOR_MOVIES_NOT_IN_YEAR.query)) {
      stmt.setInt(1, year);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        actors.add(rs.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return actors;
  }
}