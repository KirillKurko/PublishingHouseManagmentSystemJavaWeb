package beansTests.projectBeansTests.projectBeanTests;

import model.beans.employees.employeesImplementations.LeadEditor;
import model.beans.project.Book;
import model.beans.project.Project;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ProjectBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();

        project.setId(1);

        final Field id = project.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(project), 1);
    }

    @Test
    public void testSetPagesAmount() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();

        project.setPagesAmount(1);

        final Field pagesAmount = project.getClass().getDeclaredField("pagesAmount");
        pagesAmount.setAccessible(true);
        assertEquals("Fields doesn't match", pagesAmount.get(project), 1);
    }

    @Test
    public void testSetPagePrice() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();

        project.setPagePrice(10.0);

        final Field pagePrice = project.getClass().getDeclaredField("pagePrice");
        pagePrice.setAccessible(true);
        assertEquals("Fields doesn't match", pagePrice.get(project), 10.0);
    }

    @Test
    public void testSetBooksAmount() throws NoSuchFieldException, IllegalAccessException {

        final Project project = new Project();

        project.setBooksAmount(100);

        final Field booksAmount = project.getClass().getDeclaredField("booksAmount");
        booksAmount.setAccessible(true);
        assertEquals("Fields doesn't match", booksAmount.get(project), 100);
    }
}
