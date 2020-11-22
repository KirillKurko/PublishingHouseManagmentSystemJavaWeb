package beansTests.employeesBeansTests.userBeanTests;

import model.beans.employees.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class EmployeeBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field id = user.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(user, 1);

        assertEquals("field wasn't retrieved properly", user.getId(), 1);
    }

    @Test
    public void testGetLogin() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field login = user.getClass().getDeclaredField("login");
        login.setAccessible(true);
        login.set(user, "newUser");

        assertEquals("field wasn't retrieved properly", user.getLogin(), "newUser");
    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field password = user.getClass().getDeclaredField("password");
        password.setAccessible(true);
        password.set(user, "1234");

        assertEquals("field wasn't retrieved properly", user.getPassword(), "1234");
    }

    @Test
    public void testGetEmail() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field email = user.getClass().getDeclaredField("email");
        email.setAccessible(true);
        email.set(user, "newUser@gmail.com");

        assertEquals("field wasn't retrieved properly", user.getEmail(), "newUser@gmail.com");
    }

    @Test
    public void testGetRole() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field role = user.getClass().getDeclaredField("role");
        role.setAccessible(true);
        role.set(user, "admin");

        assertEquals("field wasn't retrieved properly", user.getRole(), "admin");
    }

}
