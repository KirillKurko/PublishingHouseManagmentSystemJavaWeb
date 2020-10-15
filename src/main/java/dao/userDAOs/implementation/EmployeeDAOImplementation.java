package dao.userDAOs.implementation;

import beans.employees.User;
import beans.employees.employeesImplementations.Employee;
import dao.userDAOs.interfaces.EmployeeDAO;
import utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOImplementation implements EmployeeDAO {

    private static final String INSERT_EMPLOYEE = "INSERT INTO Employee(name, surname, experience, salary, userID) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE Employee SET name = ?, surname = ?, experience = ?, salary = ?, userID = ? WHERE id = ?;";
    private static final String SELECT_USER = "SELECT * FROM Employee WHERE id = ?;";
    private static final String DELETE_USER = "DELETE FROM Employee WHERE id = ?;";

    @Override
    public void insertEmployee(Employee employee) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setInt(3, employee.getExperience());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getUserID());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public User selectEmployee(int id) {
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {
        return false;
    }
}
