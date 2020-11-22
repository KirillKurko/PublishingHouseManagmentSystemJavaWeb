package beansTests.employeesBeansTests.chiefEditorBeanTests;

import model.beans.employees.employeesImplementations.ChiefEditor;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class ChiefEditorBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final ChiefEditor chiefEditor = new ChiefEditor();
        final Field id = chiefEditor.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(chiefEditor, 1);

        assertEquals("field wasn't retrieved properly", chiefEditor.getId(), 1);
    }

    @Test
    public void testGetFinishedProjectAmount() throws NoSuchFieldException, IllegalAccessException {

        final ChiefEditor chiefEditor = new ChiefEditor();
        final Field finishedProjectAmount = chiefEditor.getClass().getDeclaredField("finishedProjectsAmount");
        finishedProjectAmount.setAccessible(true);
        finishedProjectAmount.set(chiefEditor, 10);

        assertEquals("field wasn't retrieved properly", chiefEditor.getFinishedProjectsAmount(), 10);
    }
}
