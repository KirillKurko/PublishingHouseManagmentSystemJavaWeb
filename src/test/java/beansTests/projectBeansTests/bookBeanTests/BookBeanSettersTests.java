package beansTests.projectBeansTests.bookBeanTests;

import model.beans.project.Author;
import model.beans.project.Book;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();

        book.setId(1);

        final Field id = book.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(book), 1);
    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();

        book.setName("name");

        final Field name = book.getClass().getDeclaredField("name");
        name.setAccessible(true);
        assertEquals("Fields doesn't match", "name", name.get(book));
    }

    @Test
    public void testSetTitle() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();

        book.setTitle("title");

        final Field title = book.getClass().getDeclaredField("title");
        title.setAccessible(true);
        assertEquals("Fields doesn't match", "title", title.get(book));
    }

    @Test
    public void testSetFileLink() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();

        book.setFileLink("fileLink");

        final Field fileLink = book.getClass().getDeclaredField("fileLink");
        fileLink.setAccessible(true);
        assertEquals("Fields doesn't match", "fileLink", fileLink.get(book));
    }
}
