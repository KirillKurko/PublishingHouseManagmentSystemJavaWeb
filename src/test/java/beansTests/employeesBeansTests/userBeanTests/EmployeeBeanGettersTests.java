package beansTests.employeesBeansTests.userBeanTests;

import beans.employees.User;
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
    public void testGetHash() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field hash = user.getClass().getDeclaredField("hash");
        hash.setAccessible(true);
        hash.set(user, "1234abcd");

        assertEquals("field wasn't retrieved properly", user.getHash(), "1234abcd");
    }

    @Test
    public void testIsActivated() throws NoSuchFieldException, IllegalAccessException {

        final User user = new User();
        final Field activated = user.getClass().getDeclaredField("activated");
        activated.setAccessible(true);
        activated.set(user, true);

        assertEquals("field wasn't retrieved properly", user.isActivated(), true);
    }
}
