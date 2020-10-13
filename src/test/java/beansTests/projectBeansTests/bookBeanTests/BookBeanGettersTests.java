package beansTests.projectBeansTests.bookBeanTests;

import beans.employees.project.Author;
import beans.employees.project.Book;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();
        final Field id = book.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(book, 1);

        assertEquals("field wasn't retrieved properly", book.getId(), 1);
    }

    @Test
    public void testGetAuthors() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();
        final Field authors = book.getClass().getDeclaredField("authors");
        authors.setAccessible(true);

        ArrayList<Author> authorsArray = new ArrayList<>();
        authorsArray.add(new Author("1", "1"));
        authors.set(book, authorsArray);

        assertEquals("field wasn't retrieved properly", book.getAuthors(), authorsArray);
    }

    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();
        final Field name = book.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(book, "name");

        assertEquals("field wasn't retrieved properly", book.getName(), "name");
    }

    @Test
    public void testGetTitle() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();
        final Field title = book.getClass().getDeclaredField("title");
        title.setAccessible(true);
        title.set(book, "title");

        assertEquals("field wasn't retrieved properly", book.getTitle(), "title");
    }

    @Test
    public void testGetFileLink() throws NoSuchFieldException, IllegalAccessException {

        final Book book = new Book();
        final Field fileLink = book.getClass().getDeclaredField("fileLink");
        fileLink.setAccessible(true);
        fileLink.set(book, "fileLink");

        assertEquals("field wasn't retrieved properly", book.getFileLink(), "fileLink");
    }
}
