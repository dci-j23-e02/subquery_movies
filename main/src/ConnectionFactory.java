package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
  public static final String URL = "jdbc:postgresql://localhost:5432/movies";
  private static final String USER = "safwankherallah"; // Default is postgres
  private static final String PASS = "123456";

  public static Connection getConnection(){
    try {
      return DriverManager.getConnection(URL, USER, PASS);
    }catch(SQLException e){
      e.printStackTrace();
    }
    return  null;
  }

  public static void main(String[] args) {
    Connection connection = getConnection();
    if(connection != null){
      System.out.println("Database is connected! ");
    }else {
      System.out.println("Failed to connect!");
    }
  }
}
