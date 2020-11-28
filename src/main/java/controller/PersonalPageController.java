package controller;

import controller.services.EditService;
import controller.services.employeeServices.UserService;
import model.beans.employees.User;
import model.beans.employees.employeesImplementations.ChiefEditor;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.employees.employeesImplementations.LeadEditor;
import model.dao.userDAOs.implementations.ChiefEditorDAOImplementation;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.implementations.LeadEditorDAOImplementation;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.ChiefEditorDAO;
import model.dao.userDAOs.interfaces.EmployeeDAO;
import model.dao.userDAOs.interfaces.LeadEditorDAO;
import model.dao.userDAOs.interfaces.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/personalPage")
public class PersonalPageController extends HttpServlet {

    private UserService userService;
    private UserDAO userDAO;
    private EmployeeDAO employeeDAO;
    private LeadEditorDAO leadEditorDAO;
    private ChiefEditorDAO chiefEditorDAO;
    private EditService editService;

    @Override
    public void init() {
        userService = new UserService();
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        leadEditorDAO = new LeadEditorDAOImplementation();
        chiefEditorDAO = new ChiefEditorDAOImplementation();
        editService = new EditService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getUser":
                getUser(request, response);
                break;
            case "getEmployee":
                getEmployee(request, response);
                break;
            case "getChiefEditor":
                getChiefEditor(request, response);
            case "getLeadEditor":
                getLeadEditor(request, response);
                break;
            case "editUser":
                editUser(request, response);
                getUser(request, response);
                break;
            case "editEmployee":
                editEmployee(request, response);
                getEmployee(request, response);
                break;
            case "editLeadEditor":
                editLeadEditor(request, response);
                getLeadEditor(request, response);
                break;
            case "editChiefEditor":
                editChiefEditor(request, response);
                getChiefEditor(request, response);
                break;
            case "deleteAccount":
                deleteAccount(request, response);
                break;
        }
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        User user = userDAO.selectUser(userId);
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/personalPage/personalPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = (int) request.getSession().getAttribute("employeeId");
        Employee employee = employeeDAO.selectEmployee(employeeId);
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/personalPage/employeeInformation.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = (int) request.getSession().getAttribute("employeeId");
        ChiefEditor chiefEditor = chiefEditorDAO.selectChiefEditorByEmployeeId(employeeId);
        request.setAttribute("chiefEditor", chiefEditor);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/personalPage/chiefEditorInformation.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = (int) request.getSession().getAttribute("employeeId");
        LeadEditor leadEditor = leadEditorDAO.selectLeadEditorByEmployeeId(employeeId);
        request.setAttribute("leadEditor", leadEditor);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/personalPage/leadEditorInformation.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editUser(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editEmployee(request, response);
    }

    private void editLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editLeadEditor(request, response);
    }

    private void editChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editChiefEditor(request, response);
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        userService.deleteUser(userId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("login");
        requestDispatcher.forward(request, response);
    }
}