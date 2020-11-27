package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.Employee;

import java.util.List;

public interface EmployeeDAO {

    int insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    Employee selectEmployee(int id);

    Employee selectEmployeeByUserId(int userId);

    List<Employee> selectEmployees();

    boolean deleteEmployee(int id);

    boolean deleteEmployeeByUserId(int id);
}
