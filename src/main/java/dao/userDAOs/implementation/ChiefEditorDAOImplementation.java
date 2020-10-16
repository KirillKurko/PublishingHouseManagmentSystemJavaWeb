package dao.userDAOs.implementation;

import beans.employees.employeesImplementations.ChiefEditor;
import beans.employees.employeesImplementations.Employee;
import dao.userDAOs.interfaces.ChiefEditorDAO;

public class ChiefEditorDAOImplementation implements ChiefEditorDAO {

    private static final String INSERT_CHIEF_EDITOR = "INSERT INTO Employee(name, surname, experience, salary, userID) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_EMPLOYEE = "UPDATE Employee SET name = ?, surname = ?, experience = ?, salary = ?, userID = ? WHERE id = ?;";
    private static final String SELECT_EMPLOYEE = "SELECT * FROM Employee WHERE id = ?;";
    private static final String DELETE_EMPLOYEE = "DELETE FROM Employee WHERE id = ?;";

    @Override
    public void insertChiefEditor(ChiefEditor chiefEditor) {

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
