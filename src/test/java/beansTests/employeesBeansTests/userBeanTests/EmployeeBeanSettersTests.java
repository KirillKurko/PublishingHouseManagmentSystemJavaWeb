package beansTests.employeesBeansTests.userBeanTests;

import beans.employees.User;
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
    public void testSetHash() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setHash("1234abcd");

        final Field hash = user.getClass().getDeclaredField("hash");
        hash.setAccessible(true);
        assertEquals("Fields doesn't match", hash.get(user), "1234abcd");
    }

    @Test
    public void testSetActivated() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();

        user.setActivated(true);

        final Field activated = user.getClass().getDeclaredField("activated");
        activated.setAccessible(true);
        assertEquals("Fields doesn't match", activated.get(user), true);
    }
}
