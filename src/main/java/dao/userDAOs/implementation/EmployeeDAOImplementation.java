package dao.userDAOs.implementation;

import beans.employees.employeesImplementations.Employee;
import dao.userDAOs.interfaces.EmployeeDAO;
import utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImplementation implements EmployeeDAO {

    private static final String INSERT_EMPLOYEE = "INSERT INTO Employee(name, surname, experience, salary, userID) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_EMPLOYEE = "UPDATE Employee SET name = ?, surname = ?, experience = ?, salary = ?, userID = ? WHERE id = ?;";
    private static final String SELECT_EMPLOYEE = "SELECT * FROM Employee WHERE id = ?;";
    private static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE id = ?;";

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
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setInt(3, employee.getExperience());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getUserID());
            preparedStatement.setInt(6, employee.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int experience = resultSet.getInt("experience");
                double salary = resultSet.getDouble("salary");
                int userID = resultSet.getInt("userID");
                employee = new Employee(id, name, surname, experience, salary, userID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean deleteEmployee(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
