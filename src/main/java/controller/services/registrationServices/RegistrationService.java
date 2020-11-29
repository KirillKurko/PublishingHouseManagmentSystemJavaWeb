package controller.services.registrationServices;

import model.beans.employees.User;
import model.beans.employees.employeesImplementations.ChiefEditor;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.employees.employeesImplementations.LeadEditor;
import model.beans.employees.employeesImplementations.Publisher;
import model.dao.userDAOs.implementations.*;
import model.dao.userDAOs.interfaces.*;
import utilities.Checker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationService {

    private final UserDAO userDAO;
    private final EmployeeDAO employeeDAO;
    private final LeadEditorDAO leadEditorDAO;
    private final ChiefEditorDAO chiefEditorDAO;
    private final PublisherDAO publisherDAO;

    public RegistrationService() {
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        leadEditorDAO = new LeadEditorDAOImplementation();
        chiefEditorDAO = new ChiefEditorDAOImplementation();
        publisherDAO = new PublisherDAOImplementation();
    }

    public User registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getUserFromRequest(request);
        while (!Checker.checkUsernameValid(user.getLogin(), user.getId())) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(request.getParameter("caller"));
            requestDispatcher.forward(request, response);
        }
        int id = userDAO.insertUser(user);
        user.setId(id);
        return user;
    }

    public Employee registerEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = getEmployeeFromRequest(request);
        int id = employeeDAO.insertEmployee(employee);
        employee.setId(id);
        return employee;
    }

    public LeadEditor registerLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LeadEditor leadEditor = getLeadEditorFromRequest(request);
        int id = leadEditorDAO.insertLeadEditor(leadEditor);
        leadEditor.setId(id);
        return leadEditor;
    }

    public ChiefEditor registerChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiefEditor chiefEditor = getChiefEditorFromRequest(request);
        int id = chiefEditorDAO.insertChiefEditor(chiefEditor);
        chiefEditor.setId(id);
        return chiefEditor;
    }

    public Publisher registerPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Publisher publisher = getPublisherFromRequest(request);
        int id = publisherDAO.insertPublisher(publisher);
        publisher.setId(id);
        return publisher;
    }

    private User getUserFromRequest(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        return new User(username, password, email, role);
    }

    private Employee getEmployeeFromRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int experience = Integer.parseInt(request.getParameter("experience"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        int userId = (int) request.getSession().getAttribute("addUserId");
        return new Employee(name, surname, experience, salary, userId);
    }

    private LeadEditor getLeadEditorFromRequest(HttpServletRequest request) {
        int finishedProjectsAmount = Integer.parseInt(request.getParameter("finishedProjectsAmount"));
        String mainGenre = request.getParameter("mainGenre");
        int employeeId = (int) request.getSession().getAttribute("addEmployeeId");
        return new LeadEditor(finishedProjectsAmount, mainGenre, employeeId);
    }

    private ChiefEditor getChiefEditorFromRequest(HttpServletRequest request) {
        int finishedProjectsAmount = Integer.parseInt(request.getParameter("finishedProjectsAmount"));
        int employeeId = (int) request.getSession().getAttribute("addEmployeeId");
        return new ChiefEditor(finishedProjectsAmount, employeeId);
    }

    private Publisher getPublisherFromRequest(HttpServletRequest request) {
        double finances = Double.parseDouble(request.getParameter("finances"));
        int employeeId = (int) request.getSession().getAttribute("addEmployeeId");
        return new Publisher(finances, employeeId);
    }

}
