package beansTests.employeesBeansTests.userBeanTests;

import model.beans.employees.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class EmployeeBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setId(1);

        final Field id = user.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(user), 1);
    }

    @Test
    public void testSetLogin() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setLogin("newUser");

        final Field login = user.getClass().getDeclaredField("login");
        login.setAccessible(true);
        assertEquals("Fields doesn't match", login.get(user), "newUser");
    }

    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setPassword("1234");

        final Field password = user.getClass().getDeclaredField("password");
        password.setAccessible(true);
        assertEquals("Fields doesn't match", password.get(user), "1234");
    }

    @Test
    public void testSetEmail() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setEmail("newUser@gmail.com");

        final Field email = user.getClass().getDeclaredField("email");
        email.setAccessible(true);
        assertEquals("Fields doesn't match", email.get(user), "newUser@gmail.com");
    }

    @Test
    public void testSetRole() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setRole("admin");

        final Field role = user.getClass().getDeclaredField("role");
        role.setAccessible(true);
        assertEquals("Fields doesn't match", role.get(user), "admin");
    }

}
