package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/touragency?serverTimezone=Europe/Moscow&useSSL=false";
        String userName = dbUser;
        String password = dbPass;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, userName, password);
        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + " ( " + Const.USER_FIRSTNAME + ", " + Const.USER_LASTNAME + "," +
                Const.USER_LOGIN + ", " + Const.USER_PASSWORD + ", " + Const.USER_LOCATION + ", " + Const.USER_GENDER + ") " + "VALUES (?, ?, ?, ?, ?, ?)";


        try {
            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
                prSt.setString(1, user.getFirstName());
                prSt.setString(2, user.getLastName());
                prSt.setString(3, user.getLogin());
                prSt.setString(4, user.getPassword());
                prSt.setString(5, user.getLocation());
                prSt.setString(6, user.getGender());

                prSt.executeUpdate(); // Добавляет в бд
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + "WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            resSet = prSt.executeQuery(); // Взять из бд
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Нет такого пользователя!");

        }
        return resSet;
    }
}
