package model.dao.userDAOs.interfaces;

import model.beans.employees.employeesImplementations.Employee;

public interface EmployeeDAO {

    int insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    Employee selectEmployee(int id);

    Employee selectEmployeeByUserId(int userId);

    boolean deleteEmployee(int id);
}
