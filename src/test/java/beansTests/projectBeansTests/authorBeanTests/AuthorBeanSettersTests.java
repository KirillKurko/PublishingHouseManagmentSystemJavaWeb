package beansTests.projectBeansTests.authorBeanTests;

import model.beans.project.Author;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class AuthorBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Author author = new Author();

        author.setId(1);

        final Field id = author.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(author), 1);
    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {

        final Author author = new Author();

        author.setName("name");

        final Field name = author.getClass().getDeclaredField("name");
        name.setAccessible(true);
        assertEquals("Fields doesn't match", "name", name.get(author));
    }

    @Test
    public void testSetSurname() throws NoSuchFieldException, IllegalAccessException {

        final Author author = new Author();

        author.setSurname("surname");

        final Field surname = author.getClass().getDeclaredField("surname");
        surname.setAccessible(true);
        assertEquals("Fields doesn't match", "surname", surname.get(author));
    }
}
