package beansTests.employeesBeansTests.PublisherBeanTests;

import beans.employees.employeesImplementations.Publisher;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class PublisherBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Publisher publisher = new Publisher();

        publisher.setId(1);

        final Field id = publisher.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(publisher), 1);
    }

    @Test
    public void testSetFinishedProjectsAmount() throws NoSuchFieldException, IllegalAccessException {

        final Publisher leadEditor = new Publisher();

        leadEditor.setFinances(10.2);

        final Field finances = leadEditor.getClass().getDeclaredField("finances");
        finances.setAccessible(true);
        assertEquals("Fields doesn't match", 10.2, finances.get(leadEditor));
    }
}
