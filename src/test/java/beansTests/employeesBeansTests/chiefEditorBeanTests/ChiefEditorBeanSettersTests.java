package beansTests.employeesBeansTests.chiefEditorBeanTests;

import beans.employees.employeesImplementations.ChiefEditor;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ChiefEditorBeanSettersTests {


    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final ChiefEditor chiefEditor = new ChiefEditor();

        chiefEditor.setId(1);

        final Field id = chiefEditor.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(chiefEditor), 1);
    }

    @Test
    public void testSetFinishedProjectsAmount() throws NoSuchFieldException, IllegalAccessException {

        final ChiefEditor chiefEditor = new ChiefEditor();

        chiefEditor.setFinishedProjectsAmount(10);

        final Field finishedProjectsAmount = chiefEditor.getClass().getDeclaredField("finishedProjectsAmount");
        finishedProjectsAmount.setAccessible(true);
        assertEquals("Fields doesn't match", "name", finishedProjectsAmount.get(chiefEditor));
    }
}
