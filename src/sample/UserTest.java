package sample;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @Before
    public void init() {
        user = new User("firstName", "lastName", "login", "password", "location", "gender");
    }

    @Test
    public void getFirstName() {
        assertEquals(user.getFirstName(), "firstName");
    }

    @Test
    public void setFirstName() {
        user.setFirstName("Max");
        assertEquals(user.getFirstName(), "Max");
    }

    @Test
    public void getLastName() {
        assertEquals(user.getLastName(), "lastName");
    }

    @Test
    public void setLastName() {
        user.setLastName("Ivanov");
        assertEquals(user.getLastName(), "Ivanov");
    }

    @Test
    public void getLogin() {
        assertEquals(user.getLogin(), "login");
    }

    @Test
    public void setLogin() {
        user.setLogin("myemail@mail.ru");
        assertEquals(user.getLogin(), "myemail@mail.ru");
    }

    @Test
    public void getPassword() {
        assertEquals(user.getPassword(), "password");
    }

    @Test
    public void setPassword() {
        user.setPassword("Pa$$w0rd");
        assertEquals(user.getPassword(), "Pa$$w0rd");
    }

    @Test
    public void getLocation() {
        assertEquals(user.getLocation(), "location");
    }

    @Test
    public void setLocation() {
        user.setLocation("loc");
        assertEquals(user.getLocation(), "loc");
    }

    @Test
    public void getGender() {
        assertEquals(user.getGender(), "gender");
    }

    @Test
    public void setGender() {
        user.setGender("gen");
        assertEquals(user.getGender(), "gen");
    }
}