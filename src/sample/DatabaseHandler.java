package sample;


import javafx.scene.control.Alert;

import java.sql.*;

import static sample.Const.*;


public class DatabaseHandler extends Configs {

    Connection dbConnection;
    public static User USER;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/touragency?serverTimezone=Europe/Moscow&useSSL=false";
        String userName = dbUser;
        String password = dbPass;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, userName, password);
        return dbConnection;
    }

    public void signUpUser(User user) throws SQLException {

        String insert = "INSERT INTO " + USER_TABLE + " ( " + USER_FIRSTNAME + ", " + USER_LASTNAME + "," +
                USER_LOGIN + ", " + USER_PASSWORD + ", " + USER_LOCATION + ", " + USER_GENDER + ") " + "VALUES (?, ?, ?, ?, ?, ?)";


        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, user.getFirstName());
                prSt.setString(2, user.getLastName());
                prSt.setString(3, user.getLogin());
                prSt.setString(4, user.getPassword());
                prSt.setString(5, user.getLocation());
                prSt.setString(6, user.getGender());

                // Добавляет в бд
                prSt.executeUpdate();

                dialogInfo();


            }
        } catch (SQLException | ClassNotFoundException e) {
            error();


        }
    }

    public User login(String login, String password) {
        User user = null;
        String select = "SELECT * FROM " + USER_TABLE + " WHERE " +
                USER_LOGIN + "=? AND " + USER_PASSWORD + "=?";

        try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {

            prSt.setString(1, login);
            prSt.setString(2, password);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setFirstName(USER_FIRSTNAME);
                user.setLastName(USER_LASTNAME);
                user.setGender(USER_GENDER);
                user.setLocation(resultSet.getString(USER_LOCATION));
                USER = user;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    private void dialogInfo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информационный диалог");
        alert.setHeaderText("Новый пользователь зарегистрирован!");
        alert.showAndWait();
    }

    private void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Пользователь с таким логином уже создан!");
        alert.showAndWait();
    }
}
