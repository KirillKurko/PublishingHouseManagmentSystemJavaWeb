package beansTests.projectBeansTests.authorBeanTests;

import model.beans.project.Author;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class AuthorBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Author author = new Author();
        final Field id = author.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(author, 1);

        assertEquals("field wasn't retrieved properly", author.getId(), 1);
    }

    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {

        final Author author = new Author();
        final Field name = author.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(author, "name");

        assertEquals("field wasn't retrieved properly", author.getName(), "name");
    }

    @Test
    public void testGetSurname() throws NoSuchFieldException, IllegalAccessException {

        final Author author = new Author();
        final Field surname = author.getClass().getDeclaredField("surname");
        surname.setAccessible(true);
        surname.set(author, "surname");

        assertEquals("field wasn't retrieved properly", author.getSurname(), "surname");
    }
}
