package beansTests.employeesBeansTests.employeeBeanTests;

import model.beans.employees.employeesImplementations.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Field;

public class EmployeeBeanGettersTests {

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();
        final Field id = employee.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(employee, 1);

        assertEquals("field wasn't retrieved properly", employee.getId(), 1);
    }

    @Test
    public void testGetName() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();
        final Field name = employee.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(employee, "name");

        assertEquals("field wasn't retrieved properly", employee.getName(), "name");
    }

    @Test
    public void testGetSurname() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();
        final Field surname = employee.getClass().getDeclaredField("surname");
        surname.setAccessible(true);
        surname.set(employee, "surname");

        assertEquals("field wasn't retrieved properly", employee.getSurname(), "surname");
    }

    @Test
    public void testGetExperience() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();
        final Field experience = employee.getClass().getDeclaredField("experience");
        experience.setAccessible(true);
        experience.set(employee, 10);

        assertEquals("field wasn't retrieved properly", employee.getExperience(), 10);
    }

    @Test
    public void testGetSalary() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();
        final Field salary = employee.getClass().getDeclaredField("salary");
        salary.setAccessible(true);
        salary.set(employee, 10.3);

        assertEquals("field wasn't retrieved properly", employee.getSalary(), 10.3, 0.0001);
    }

    @Test
    public void testGetUserID() throws NoSuchFieldException, IllegalAccessException {

        final Employee employee = new Employee();
        final Field userID = employee.getClass().getDeclaredField("userID");
        userID.setAccessible(true);
        userID.set(employee, 4);

        assertEquals("field wasn't retrieved properly", employee.getUserID(), 4);
    }
}
