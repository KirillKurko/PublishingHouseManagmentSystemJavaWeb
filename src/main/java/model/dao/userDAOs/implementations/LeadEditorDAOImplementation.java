package model.dao.userDAOs.implementations;

import model.beans.employees.employeesImplementations.LeadEditor;
import model.dao.userDAOs.interfaces.LeadEditorDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeadEditorDAOImplementation implements LeadEditorDAO {

    private static final String INSERT_LEAD_EDITOR = "INSERT INTO LeadEditor(finishedProjectsAmount, mainGenre, employeeID) VALUES (?, ?, ?);";
    private static final String UPDATE_LEAD_EDITOR = "UPDATE LeadEditor SET finishedProjectsAmount = ?, mainGenre = ?, employeeID = ? WHERE id = ?;";
    private static final String SELECT_LEAD_EDITOR = "SELECT * FROM LeadEditor WHERE id = ?;";
    private static final String SELECT_LEAD_EDITORS = "SELECT * FROM LeadEditor;";
    private static final String DELETE_LEAD_EDITOR = "DELETE FROM LeadEditor WHERE id = ?;";
    private static final String DELETE_LEAD_EDITOR_BY_EMPLOYEE_ID = "DELETE FROM LeadEditor WHERE employeeID = ?;";

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
    public List<LeadEditor> selectLeadEditors() {
        List<LeadEditor> leadEditors = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LEAD_EDITORS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int finishedProjectsAmount = resultSet.getInt("finishedProjectsAmount");
                String mainGenre = resultSet.getString("mainGenre");
                int employeeID = resultSet.getInt("employeeID");
                leadEditors.add(new LeadEditor(id, finishedProjectsAmount, mainGenre, employeeID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return leadEditors;
    }


    @Override
    public boolean deleteLeadEditor(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LEAD_EDITOR)) {
            preparedStatement.setInt(1 ,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean deleteLeadEditorByEmployeeId(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LEAD_EDITOR_BY_EMPLOYEE_ID)) {
            preparedStatement.setInt(1 ,id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
