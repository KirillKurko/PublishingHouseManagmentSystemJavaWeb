package beansTests.projectBeansTests.taskBeanTests;

import model.beans.project.Task;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class TaskBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Task task = new Task();
        final Field id = task.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(task, 1);

        assertEquals("field wasn't retrieved properly", task.getId(), 1);
    }

    @Test
    public void testGetDescription() throws NoSuchFieldException, IllegalAccessException {

        final Task task = new Task();
        final Field description = task.getClass().getDeclaredField("description");
        description.setAccessible(true);
        description.set(task, "description");

        assertEquals("field wasn't retrieved properly", task.getDescription(), "description");
    }

    @Test
    public void testGetEmployeeID() throws NoSuchFieldException, IllegalAccessException {

        final Task task = new Task();
        final Field employeeID = task.getClass().getDeclaredField("employeeID");
        employeeID.setAccessible(true);
        employeeID.set(task, 12);

        assertEquals("field wasn't retrieved properly", task.getEmployeeID(), 12);
    }
}
