package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(String firstName, String lastName, String login, String password, String location, String gender){
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" + Const.USER_FIRSTNAME + "," + Const.USER_LASTNAME + "," +
                Const.USER_LOGIN + "," + Const.USER_LOCATION + "," + Const.USER_GENDER + ")" + "VALUES(?,?,?,?,?,?)";


        try {
            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {
                prSt.setString(1, firstName);
                prSt.setString(2, lastName);
                prSt.setString(3, login);
                prSt.setString(4, password);
                prSt.setString(5, location);
                prSt.setString(6, gender);

                prSt.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }
    }
}
