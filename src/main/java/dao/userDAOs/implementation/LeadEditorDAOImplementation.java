package dao.userDAOs.implementation;

import beans.employees.employeesImplementations.LeadEditor;
import dao.userDAOs.interfaces.LeadEditorDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class LeadEditorDAOImplementation implements LeadEditorDAO {

    private static final String INSERT_LEAD_EDITOR = "INSERT INTO LeadEditor(finishedProjectsAmount, mainGenre, employeeID) VALUES (?, ?, ?);";
    private static final String UPDATE_LEAD_EDITOR = "UPDATE LeadEditor SET finishedProjectsAmount = ?, mainGenre = ?, employeeID = ? WHERE id = ?;";
    private static final String SELECT_LEAD_EDITOR = "SELECT * FROM LeadEditor WHERE id = ?;";
    private static final String DELETE_LEAD_EDITOR = "DELETE FROM LeadEditor WHERE id = ?;";

    @Override
    public int insertLeadEditor(LeadEditor chiefEditor) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LEAD_EDITOR, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, chiefEditor.getFinishedProjectsAmount());
            preparedStatement.setString(2, chiefEditor.getMainGenre());
            preparedStatement.setInt(3, chiefEditor.getEmployeeID());
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
    public boolean updateLeadEditor(LeadEditor chiefEditor) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LEAD_EDITOR)) {
            preparedStatement.setInt(1, chiefEditor.getFinishedProjectsAmount());
            preparedStatement.setString(2, chiefEditor.getMainGenre());
            preparedStatement.setInt(3, chiefEditor.getEmployeeID());
            preparedStatement.setInt(4, chiefEditor.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public LeadEditor selectLeadEditor(int id) {
        LeadEditor leadEditor = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LEAD_EDITOR)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int finishedProjectsAmount = resultSet.getInt("finishedProjectsAmount");
                String mainGenre = resultSet.getString("mainGenre");
                int employeeID = resultSet.getInt("employeeID");
                leadEditor = new LeadEditor(id, finishedProjectsAmount, mainGenre, employeeID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return leadEditor;
    }

    @Override
    public boolean deleteLeadEditor(int id) {
        return false;
    }
}
