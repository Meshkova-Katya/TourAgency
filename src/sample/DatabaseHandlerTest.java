package sample;

import org.junit.Ignore;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DatabaseHandlerTest {

    /**
     * Тест на подключение к бд
     */
    @Ignore
    @org.junit.Test
    public void getDbConnection() {
        DatabaseHandler db = new DatabaseHandler();
        try {
            db.getDbConnection();
        } catch (ClassNotFoundException e) {
            fail("Driver for database not found");
        } catch (SQLException sqlException) {
            fail("Can't connect to database");
        }
    }
}