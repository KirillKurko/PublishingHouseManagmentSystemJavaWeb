package controller.services.projectServices;

import model.beans.employees.User;
import model.beans.employees.employeesImplementations.ChiefEditor;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.employees.employeesImplementations.LeadEditor;
import model.beans.employees.employeesImplementations.Publisher;
import model.beans.project.Project;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.implementations.ProjectDAOImplementation;
import model.dao.projectDAOs.interfaces.BookDAO;
import model.dao.projectDAOs.interfaces.ProjectDAO;
import model.dao.userDAOs.implementations.*;
import model.dao.userDAOs.interfaces.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProjectService {

    private final LeadEditorDAO leadEditorDAO;
    private final ChiefEditorDAO chiefEditorDAO;
    private final BookDAO bookDAO;
    private final AuthorService authorService;
    private final PublisherDAO publisherDAO;
    private final ProjectDAO projectDAO;
    private final EmployeeDAO employeeDAO;
    private final UserDAO userDAO;

    public ProjectService() {
        leadEditorDAO = new LeadEditorDAOImplementation();
        chiefEditorDAO = new ChiefEditorDAOImplementation();
        bookDAO = new BookDAOImplementation();
        authorService = new AuthorService();
        publisherDAO = new PublisherDAOImplementation();
        projectDAO = new ProjectDAOImplementation();
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
    }

    public void finishProject(HttpServletRequest request) {
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        Project project = projectDAO.selectProject(projectId);
        double projectCost = calculateProjectCost(project);
        boolean projectPaid = changeFinances(projectCost);
        if (projectPaid) {
            updateLeadEditorFinishedProjectsAmount(project);
            updateChiefEditorsFinishedProjectsAmount();
            projectDAO.deleteProject(projectId);
            removeBook(project);
        }
    }

    private void updateLeadEditorFinishedProjectsAmount(Project project) {
        int leadEditorId = project.getLeadEditorId();
        LeadEditor leadEditor = leadEditorDAO.selectLeadEditor(leadEditorId);
        int finishedProjectsAmount = leadEditor.getFinishedProjectsAmount();
        leadEditor.setFinishedProjectsAmount(finishedProjectsAmount + 1);
        leadEditorDAO.updateLeadEditor(leadEditor);
    }

    private void updateChiefEditorsFinishedProjectsAmount() {
        List<ChiefEditor> chiefEditors = chiefEditorDAO.selectChiefEditors();
        for (ChiefEditor chiefEditor: chiefEditors) {
            updateChiefEditorFinishedProjectsAmount(chiefEditor);
        }
    }

    private void updateChiefEditorFinishedProjectsAmount(ChiefEditor chiefEditor) {
        int finishedProjectsAmount = chiefEditor.getFinishedProjectsAmount();
        chiefEditor.setFinishedProjectsAmount(finishedProjectsAmount + 1);
        chiefEditorDAO.updateChiefEditor(chiefEditor);
    }

    private void removeBook(Project project) {
        int bookId = project.getBookId();
        authorService.deleteBookAuthors(bookId);
        bookDAO.deleteBook(bookId);
    }

    private double calculateProjectCost(Project project) {
        return project.getPagePrice() * project.getPagesAmount() * project.getBooksAmount();
    }

    private boolean changeFinances(double projectCost) {
        boolean projectPaid = false;
        List<Publisher> publishers = publisherDAO.selectPublishers();
        for (Publisher publisher: publishers) {
            if (projectPaid) {
                break;
            }
            projectPaid = updatePublisherFinances(publisher, projectCost);
        }
        return projectPaid;
    }

    private boolean updatePublisherFinances(Publisher publisher, double projectCost) {
        boolean financesUpdated = false;
        double finances = publisher.getFinances();
        if (finances >= projectCost) {
            finances -= projectCost;
            publisher.setFinances(finances);
            publisherDAO.updatePublisher(publisher);
            financesUpdated = true;
        }
        return financesUpdated;
    }

    public User getLeadEditorUser(Project project) {
        LeadEditor leadEditor = leadEditorDAO.selectLeadEditor(project.getLeadEditorId());
        Employee employee = employeeDAO.selectEmployee(leadEditor.getEmployeeID());
        return userDAO.selectUser(employee.getUserID());
    }
}
