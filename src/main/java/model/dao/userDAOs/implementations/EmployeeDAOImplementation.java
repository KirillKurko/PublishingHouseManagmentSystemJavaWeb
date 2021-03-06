package model.dao.userDAOs.implementations;

import model.beans.employees.employeesImplementations.Employee;
import model.dao.userDAOs.interfaces.EmployeeDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImplementation implements EmployeeDAO {

    private static final String INSERT_EMPLOYEE = "INSERT INTO Employee(name, surname, experience, salary, userID) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_EMPLOYEE = "UPDATE Employee SET name = ?, surname = ?, experience = ?, salary = ?, userID = ? WHERE id = ?;";
    private static final String SELECT_EMPLOYEE = "SELECT * FROM Employee WHERE id = ?;";
    private static final String SELECT_EMPLOYEES = "SELECT * FROM Employee;";
    private static final String SELECT_EMPLOYEE_BY_USER_ID = "SELECT * FROM Employee WHERE userID = ?;";
    private static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE id = ?;";
    private static final String DELETE_EMPLOYEE_BY_USER_ID = "DELETE FROM Employee WHERE userID = ?;";

    @Override
    public int insertEmployee(Employee employee) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getSurname());
            preparedStatement.setInt(3, employee.getExperience());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setInt(5, employee.getUserID());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return id;
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
            preparedStatement.setInt(1, id);
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
    public List<Employee> selectEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int experience = resultSet.getInt("experience");
                double salary = resultSet.getDouble("salary");
                int userID = resultSet.getInt("userID");
                employees.add(new Employee(id, name, surname, experience, salary, userID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return employees;
    }

    @Override
    public Employee selectEmployeeByUserId(int userId) {
        Employee employee = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_USER_ID)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int experience = resultSet.getInt("experience");
                double salary = resultSet.getDouble("salary");
                employee = new Employee(id, name, surname, experience, salary, userId);
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

    @Override
    public boolean deleteEmployeeByUserId(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_USER_ID)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
