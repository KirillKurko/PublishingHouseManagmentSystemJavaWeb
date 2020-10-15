package beansTests.projectBeansTests.taskBeanTests;

import beans.project.Task;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class TaskBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Task task = new Task();

        task.setId(1);

        final Field id = task.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(task), 1);
    }

    @Test
    public void testSetDescription() throws NoSuchFieldException, IllegalAccessException {

        final Task task = new Task();

        task.setDescription("description");

        final Field description = task.getClass().getDeclaredField("description");
        description.setAccessible(true);
        assertEquals("Fields doesn't match", description.get(task), "description");
    }

    @Test
    public void testSetEmployeeID() throws NoSuchFieldException, IllegalAccessException {

        final Task task = new Task();

        task.setEmployeeID(1);

        final Field employeeID = task.getClass().getDeclaredField("employeeID");
        employeeID.setAccessible(true);
        assertEquals("Fields doesn't match", employeeID.get(task), 1);
    }
}
