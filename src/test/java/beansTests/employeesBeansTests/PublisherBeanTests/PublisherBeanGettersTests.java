package beansTests.employeesBeansTests.PublisherBeanTests;

import beans.employees.employeesImplementations.Publisher;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class PublisherBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Publisher publisher = new Publisher();
        final Field id = publisher.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(publisher, 1);

        assertEquals("field wasn't retrieved properly", publisher.getId(), 1);
    }

    @Test
    public void testGetFinances() throws NoSuchFieldException, IllegalAccessException {

        final Publisher publisher = new Publisher();
        final Field finances = publisher.getClass().getDeclaredField("finances");
        finances.setAccessible(true);
        finances.set(publisher, 10.2);

        assertEquals("field wasn't retrieved properly", publisher.getFinances(), 10.2, 0.0001);
    }
}
