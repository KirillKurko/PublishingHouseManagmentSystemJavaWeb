package dao.userDAOs.implementation;

import beans.employees.employeesImplementations.ChiefEditor;
import beans.employees.employeesImplementations.Employee;
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
        return false;
    }

    @Override
    public Employee selectChiefEditor(int id) {
        return null;
    }

    @Override
    public boolean deleteChiefEditor(int id) {
        return false;
    }
}
