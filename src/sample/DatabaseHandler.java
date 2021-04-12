package sample;


import java.sql.*;

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

    public void signUpUser(User user) throws SQLException {

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
                System.out.println("Новый пользователь зарегистрирован!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Пользователь с таким логином уже создан!");
            return;
        }
    }

    public boolean login(String login, String password) {

        boolean result = false;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=?";
        try (PreparedStatement prSt = getDbConnection().prepareStatement(select)) {
            prSt.setString(1, login);
            prSt.setString(2, password);


            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                result = true;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
