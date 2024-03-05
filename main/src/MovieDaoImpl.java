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

  @Override
  public List<String> findActorsByMovieReleaseYears(List<Integer> years) {
    List<String> actorsNames = new ArrayList<>();
    Integer[] yearsArray = years.toArray(new Integer[0]);

    try(
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.FIND_ACTORS_BY_MOVIE_RELEASE_YEARS.query);
    ){
      preparedStatement.setArray(1, connection.createArrayOf("integer", yearsArray));
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()){
        actorsNames.add(resultSet.getString("name"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return actorsNames;
  }

  @Override
  public List<Movie> findMoviesNewerThanGenre(String genre) {
    List<Movie> movies = new ArrayList<>();
    try(
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement pstmn = connection.prepareStatement(SqlQuery.FIND_MOVIES_NEWER_THAN_ALL_GENRE.query);
        ){
      pstmn.setString(1, genre);
      ResultSet rs = pstmn.executeQuery();
      while (rs.next()){
        Movie m = new Movie();
        m.setId(rs.getInt("id"));
        m.setTitle(rs.getString("title"));
        m.setReleaseYear(rs.getInt("release_year"));
        m.setGenre(rs.getString("genre"));
        movies.add(m);
//        movies.add(new Movie(
//            rs.getInt("id"),
//            rs.getString("title"),
//            ...
//        ));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }
}