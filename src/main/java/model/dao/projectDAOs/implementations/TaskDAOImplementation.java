package model.dao.projectDAOs.implementations;

import model.beans.project.Task;
import model.dao.projectDAOs.interfaces.TaskDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImplementation implements TaskDAO {

    private static final String INSERT_TASK = "INSERT INTO Task(name, description, customerName, executorName, employeeID) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_TASK  = "UPDATE Task SET name = ?, description = ?, customerName = ?, executorName = ?, employeeID = ? WHERE id = ?;";
    private static final String SELECT_TASK  = "SELECT * FROM Task WHERE id = ?;";
    private static final String SELECT_TASK_BY_CUSTOMER_NAME  = "SELECT * FROM Task WHERE customerName = ?;";
    private static final String SELECT_TASK_BY_EMPLOYEE_ID  = "SELECT * FROM Task WHERE employeeID = ?;";
    private static final String SELECT_TASKS  = "SELECT * FROM Task;";
    private static final String DELETE_TASK  = "DELETE FROM Task WHERE id = ?;";

    @Override
    public int insertTask(Task task) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getCustomerName());
            preparedStatement.setString(4, task.getExecutorName());
            preparedStatement.setInt(5, task.getEmployeeID());
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
    public boolean updateTask(Task task) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TASK)) {
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getCustomerName());
            preparedStatement.setString(4, task.getExecutorName());
            preparedStatement.setInt(5, task.getEmployeeID());
            preparedStatement.setInt(6, task.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Task selectTask(int id) {
        Task task = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name  = resultSet.getString("name");
                String description = resultSet.getString("description");
                int employeeID = resultSet.getInt("employeeID");
                String customerName = resultSet.getString("customerName");
                String executorName = resultSet.getString("executorName");
                task = new Task(id, name, description, customerName, executorName, employeeID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return task;
    }

    @Override
    public List<Task> selectTasks() {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASKS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name  = resultSet.getString("name");
                String description = resultSet.getString("description");
                int employeeID = resultSet.getInt("employeeID");
                String customerName = resultSet.getString("customerName");
                String executorName = resultSet.getString("executorName");
                tasks.add(new Task(id, name, description, customerName, executorName, employeeID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<Task> selectTasksByCustomerName(String customerName) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_CUSTOMER_NAME)) {
            preparedStatement.setString(1, customerName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name  = resultSet.getString("name");
                String description = resultSet.getString("description");
                int employeeID = resultSet.getInt("employeeID");
                String executorName = resultSet.getString("executorName");
                tasks.add(new Task(id, name, description, customerName, executorName, employeeID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return tasks;
    }

    @Override
    public List<Task> selectTasksByEmployeeId(int employeeId) {
        List<Task> tasks = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TASK_BY_EMPLOYEE_ID)) {
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name  = resultSet.getString("name");
                String description = resultSet.getString("description");
                String customerName = resultSet.getString("customerName");
                String executorName = resultSet.getString("executorName");
                tasks.add(new Task(id, name, description, customerName, executorName, employeeId));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return tasks;
    }

    @Override
    public boolean deleteTask(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TASK)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
