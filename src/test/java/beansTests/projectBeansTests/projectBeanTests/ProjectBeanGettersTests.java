package beansTests.projectBeansTests.projectBeanTests;

import model.beans.employees.employeesImplementations.LeadEditor;
import model.beans.project.Book;
import model.beans.project.Project;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ProjectBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();
        final Field id = project.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(project, 1);

        assertEquals("field wasn't retrieved properly", project.getId(), 1);
    }

    @Test
    public void testGetPagesAmount() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();
        final Field pagesAmount = project.getClass().getDeclaredField("pagesAmount");
        pagesAmount.setAccessible(true);
        pagesAmount.set(project, 10);

        assertEquals("field wasn't retrieved properly", project.getPagesAmount(), 10);
    }

    @Test
    public void testGetPagePrice() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();
        final Field pagePrice = project.getClass().getDeclaredField("pagePrice");
        pagePrice.setAccessible(true);
        pagePrice.set(project, 12.8);

        assertEquals("field wasn't retrieved properly", project.getPagePrice(), 12.8, 0.001);
    }

    @Test
    public void testGetBooksAmount() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();
        final Field booksAmount = project.getClass().getDeclaredField("booksAmount");
        booksAmount.setAccessible(true);
        booksAmount.set(project, 100);

        assertEquals("field wasn't retrieved properly", project.getBooksAmount(), 100);
    }
}
