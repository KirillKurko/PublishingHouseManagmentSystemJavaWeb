package controller.services.employeeServices;

import model.beans.employees.User;
import model.dao.projectDAOs.implementations.TaskDAOImplementation;
import model.dao.projectDAOs.interfaces.TaskDAO;
import model.dao.userDAOs.implementations.*;
import model.dao.userDAOs.interfaces.*;

public class UserService {

    private final UserDAO userDAO;
    private final EmployeeDAO employeeDAO;
    private final PublisherDAO publisherDAO;
    private final LeadEditorDAO leadEditorDAO;
    private final ChiefEditorDAO chiefEditorDAO;
    private final TaskDAO taskDAO;

    public UserService() {
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        publisherDAO = new PublisherDAOImplementation();
        leadEditorDAO = new LeadEditorDAOImplementation();
        chiefEditorDAO = new ChiefEditorDAOImplementation();
        taskDAO = new TaskDAOImplementation();
    }

    public void deleteUser(int id) {
        User user = userDAO.selectUser(id);
        String role = user.getRole();
        int employeeId = employeeDAO.selectEmployeeByUserId(user.getId()).getId();
        if (role.equals("publisher")) {
            deletePublisherByEmployeeId(employeeId);
        }
        else if (role.equals("chiefEditor")) {
            deleteChiefEditorByEmployeeId(employeeId);
        }
        else if (role.equals("leadEditor")) {
            deleteLeadEditorByEmployeeId(employeeId);
        }
        deleteTasks(employeeId);
        deleteEmployeeByUserId(id);
        userDAO.deleteUser(id);
    }

    private void deleteEmployeeByUserId(int id) {
        employeeDAO.deleteEmployeeByUserId(id);
    }

    private void deletePublisherByEmployeeId(int id) {
        publisherDAO.deletePublisherByEmployeeId(id);
    }

    private void deleteChiefEditorByEmployeeId(int id) {
        chiefEditorDAO.deleteChiefEditorByEmployeeId(id);
    }

    private void deleteLeadEditorByEmployeeId(int id) {
        leadEditorDAO.deleteLeadEditorByEmployeeId(id);
    }

    private void deleteTasks(int employeeId) {
        taskDAO.deleteTasksByEmployeeId(employeeId);
    }
}
