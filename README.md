# Movie Database Application with Subquery Demonstrations

This application showcases the use of advanced data types and subqueries in PostgreSQL, utilizing JDBC for database interaction. It's designed to manage a movie database, demonstrating operations like finding movies with specific actors, checking for movies released in a certain year, and categorizing movies by genre using various subquery techniques.

## Understanding Subqueries

A subquery is a SQL query nested inside a larger query. They are used to perform operations that require multiple steps of logic in SQL and can return data that will be used in the main query as a condition to further refine the data being selected. Subqueries can be used in `SELECT`, `INSERT`, `UPDATE`, and `DELETE` statements, among others.

### Types of Subqueries Demonstrated

- **EXISTS**: Checks if any rows are returned by the subquery.
- **IN**: Checks if the operand is equal to one of a list of expressions returned by the subquery.
- **NOT IN**: Checks if the operand is not equal to any of a list of expressions returned by the subquery.
- **ANY / SOME**: Compares a value to each value in a list returned by a subquery.
- **ALL**: Compares a value to every value in a list returned by a subquery.
- **Single-Row Comparison**: Compares scalar values returned by a subquery.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 8 or higher
- PostgreSQL Server (Version 16 recommended)
- JDBC Driver for PostgreSQL

### Setting Up

1. **Database Setup**

   Install PostgreSQL and create a `moviesdb` database. Populate it with the necessary tables (`movies`, `actors`, etc.).

2. **Application Configuration**

   Open `ConnectionFactory.java` and update the database connection details (`URL`, `USER`, `PASS`) to match your setup.

3. **Compilation**

   Compile the Java files. In the terminal, navigate to the project directory and run:
   ```
   javac *.java
   ```

### Running the Application

Execute the application with:
```
java App
```
This runs the `App.java` class, demonstrating various subquery operations on the movie database.

## Application Structure

- **ConnectionFactory.java**: Manages database connections.
- **Movie.java**: The movie data model.
- **MovieDao.java**: Interface defining movie data operations.
- **MovieDaoImpl.java**: Implements the DAO interface, showcasing subquery usage.
- **SqlQuery Enum**: Contains SQL queries with subqueries.
- **App.java**: Main class demonstrating subquery operations.

## Technologies

- [Java](https://www.oracle.com/java/) - Programming language
- [PostgreSQL](https://www.postgresql.org/) - Database management system
- [JDBC](https://jdbc.postgresql.org/) - Java Database Connectivity

## Author

- **Safwan K.**

## License

This project is licensed under the MIT License.
Developed for **DCI Digital Career Institute**

## Acknowledgments

- Thanks to the PostgreSQL documentation for detailed subquery expressions.
- Gratitude to the Java community for JDBC development resources.
