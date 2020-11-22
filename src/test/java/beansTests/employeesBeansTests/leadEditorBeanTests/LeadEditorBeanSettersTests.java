package beansTests.employeesBeansTests.leadEditorBeanTests;

import model.beans.employees.employeesImplementations.LeadEditor;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class LeadEditorBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final LeadEditor leadEditor = new LeadEditor();

        leadEditor.setId(1);

        final Field id = leadEditor.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(leadEditor), 1);
    }

    @Test
    public void testSetFinishedProjectsAmount() throws NoSuchFieldException, IllegalAccessException {

        final LeadEditor leadEditor = new LeadEditor();

        leadEditor.setFinishedProjectsAmount(10);

        final Field finishedProjectsAmount = leadEditor.getClass().getDeclaredField("finishedProjectsAmount");
        finishedProjectsAmount.setAccessible(true);
        assertEquals("Fields doesn't match", 10, finishedProjectsAmount.get(leadEditor));
    }

    @Test
    public void testSetMainGenre() throws NoSuchFieldException, IllegalAccessException {

        final LeadEditor leadEditor = new LeadEditor();

        leadEditor.setMainGenre("science");

        final Field mainGenre = leadEditor.getClass().getDeclaredField("mainGenre");
        mainGenre.setAccessible(true);
        assertEquals("Fields doesn't match", "science", mainGenre.get(leadEditor));
    }

}
