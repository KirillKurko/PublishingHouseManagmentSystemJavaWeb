package dao.projectDAOs.implementations;

import beans.project.Task;
import dao.projectDAOs.interfaces.TaskDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class TaskDAOImplementation implements TaskDAO {

    private static final String INSERT_TASK = "INSERT INTO Task(description, employeeID) VALUES (?, ?);";
    private static final String UPDATE_TASK  = "UPDATE Task SET description = ?, employeeID = ? WHERE id = ?;";
    private static final String SELECT_TASK  = "SELECT * FROM Task WHERE id = ?;";
    private static final String DELETE_TASK  = "DELETE FROM Task WHERE id = ?;";

    @Override
    public int insertTask(Task task) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TASK, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, task.getDescription());
            preparedStatement.setInt(2, task.getEmployeeID());
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
        return false;
    }

    @Override
    public Task selectTask(int id) {
        return null;
    }

    @Override
    public boolean deleteTask(int id) {
        return false;
    }
}
