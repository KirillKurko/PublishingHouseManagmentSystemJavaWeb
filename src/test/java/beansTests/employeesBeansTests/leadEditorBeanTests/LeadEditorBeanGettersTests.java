package beansTests.employeesBeansTests.leadEditorBeanTests;

import model.beans.employees.employeesImplementations.LeadEditor;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class LeadEditorBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final LeadEditor leadEditor = new LeadEditor();
        final Field id = leadEditor.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(leadEditor, 1);

        assertEquals("field wasn't retrieved properly", leadEditor.getId(), 1);
    }

    @Test
    public void testGetFinishedProjectAmount() throws NoSuchFieldException, IllegalAccessException {

        final LeadEditor leadEditor= new LeadEditor();
        final Field finishedProjectAmount = leadEditor.getClass().getDeclaredField("finishedProjectsAmount");
        finishedProjectAmount.setAccessible(true);
        finishedProjectAmount.set(leadEditor, 10);

        assertEquals("field wasn't retrieved properly", leadEditor.getFinishedProjectsAmount(), 10);
    }

    @Test
    public void testGetMainGenre() throws NoSuchFieldException, IllegalAccessException {

        final LeadEditor leadEditor = new LeadEditor();
        final Field mainGenre = leadEditor.getClass().getDeclaredField("mainGenre");
        mainGenre.setAccessible(true);
        mainGenre.set(leadEditor, "horror");

        assertEquals("field wasn't retrieved properly", leadEditor.getMainGenre(), "horror");
    }
}
