package BeansTests.employeeBeanTests;

import beans.employees.employeesImplementations.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

public class EmployeeBeanSettersTests {

    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();

        employee.setId(1);

        final Field id = employee.getClass().getDeclaredField("id");
        id.setAccessible(true);
        assertEquals("Fields doesn't match", id.get(employee), 1);
    }

    @Test
    public void testSetName() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();

        employee.setName("name");

        final Field name = employee.getClass().getDeclaredField("name");
        name.setAccessible(true);
        assertEquals("Fields doesn't match", "name", name.get(employee));
    }

    @Test
    public void testSetSurname() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();

        employee.setSurname("surname");

        final Field surname = employee.getClass().getDeclaredField("surname");
        surname.setAccessible(true);
        assertEquals("Fields doesn't match", "surname", surname.get(employee));
    }

    @Test
    public void testSetExperience() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();

        employee.setExperience(10);

        final Field experience = employee.getClass().getDeclaredField("experience");
        experience.setAccessible(true);
        assertEquals("Fields doesn't match", 10, experience.get(employee));
    }

    @Test
    public void testSetSalary() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();

        employee.setSalary(120.5);

        final Field salary = employee.getClass().getDeclaredField("salary");
        salary.setAccessible(true);
        assertEquals("Fields doesn't match", 120.5, salary.get(employee));
    }

    @Test
    public void testSetUserID() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();

        employee.setUserID(12);

        final Field userID = employee.getClass().getDeclaredField("userID");
        userID.setAccessible(true);
        assertEquals("Fields doesn't match", 12, userID.get(employee));
    }
}
