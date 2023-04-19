package lesson24;
/*
Дз по SQL❗️❗️❗️
Написать скрипт по созданию 2 таблиц: author(id,name,surname), book(id, title, authod_id, pages).
Заполнить таблицы данными(через скрипт)
Вывести данные о всех авторах и его книгах(использовать join).
Вывести все книги, где количество страниц больше 300.

Доп.задание (со *)
Вывести авторов у которых есть хотя бы 1 книги, где количество страниц больше 300.
 */

import java.sql.*;

public class Main {

    public static String url = "jdbc:mysql://localhost:3306/affafa";
    public static String username = "root";
    public static String password = "root";

    public static void createBookTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE book" +
                    "(id INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR(50)," +
                    "author_id INT," +
                    "pages INT," +
                    "FOREIGN KEY (author_id) REFERENCES author(id))"
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createAuthorTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE author(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "firstName VARCHAR(50)," +
                    "lastName VARCHAR(50))"
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (NullPointerException | SQLException e) {
                System.out.println(e.getMessage());
            } 
        }
    }

    public static void fillInAuthorTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            statement.executeUpdate(
                    "INSERT INTO author(firstName, lastName)" +
                    "VALUES ('Александр', 'Пушкин'), ('Хер', 'Лермонтов')"
        );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static void fillInBookTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            statement.executeUpdate(
                    "INSERT INTO book(title, author_id, pages)" +
                    "VALUES ('Евгений Онегин', 1, 100), ('Семь богатырей', 1, 20)," +
                            "('История беларуси гы', 2, 500)"
            );

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                statement.close();
                connection.close();
            } catch (NullPointerException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        //createAuthorTable();
        //createBookTable();

        //fillInAuthorTable();
        //fillInBookTable();
    }
}
