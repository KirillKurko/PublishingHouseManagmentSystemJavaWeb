package dao.userDAOs.interfaces;

import beans.employees.employeesImplementations.Employee;

public interface EmployeeDAO {

    void insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    Employee selectEmployee(int id);

    boolean deleteEmployee(int id);
}
