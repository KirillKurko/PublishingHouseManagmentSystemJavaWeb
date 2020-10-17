package dao.userDAOs.implementations;

import beans.employees.employeesImplementations.ChiefEditor;
import dao.userDAOs.interfaces.ChiefEditorDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class ChiefEditorDAOImplementation implements ChiefEditorDAO {

    private static final String INSERT_CHIEF_EDITOR = "INSERT INTO ChiefEditor(finishedProjectsAmount, employeeID) VALUES (?, ?);";
    private static final String UPDATE_CHIEF_EDITOR = "UPDATE ChiefEditor SET finishedProjectsAmount = ?, employeeID = ? WHERE id = ?;";
    private static final String SELECT_CHIEF_EDITOR = "SELECT * FROM ChiefEditor WHERE id = ?;";
    private static final String DELETE_CHIEF_EDITOR = "DELETE FROM ChiefEditor WHERE id = ?;";

    @Override
    public int insertChiefEditor(ChiefEditor chiefEditor) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHIEF_EDITOR, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, chiefEditor.getFinishedProjectsAmount());
            preparedStatement.setInt(2, chiefEditor.getEmployeeID());
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
    public boolean updateChiefEditor(ChiefEditor chiefEditor) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CHIEF_EDITOR)) {
            preparedStatement.setInt(1, chiefEditor.getFinishedProjectsAmount());
            preparedStatement.setInt(1, chiefEditor.getEmployeeID());
            preparedStatement.setInt(1, chiefEditor.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public ChiefEditor selectChiefEditor(int id) {
        ChiefEditor chiefEditor = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHIEF_EDITOR)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int finishedProjectsAmount = resultSet.getInt("finishedProjectsAmount");
                int employeeID =  resultSet.getInt("employeeID");
                chiefEditor = new ChiefEditor(id, finishedProjectsAmount, employeeID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return chiefEditor;
    }

    @Override
    public boolean deleteChiefEditor(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CHIEF_EDITOR)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
