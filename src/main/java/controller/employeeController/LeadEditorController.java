package controller.employeeController;

import controller.services.employeeServices.UserService;
import model.beans.employees.employeesImplementations.Employee;
import model.beans.employees.employeesImplementations.LeadEditor;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.implementations.LeadEditorDAOImplementation;
import model.dao.userDAOs.interfaces.EmployeeDAO;
import model.dao.userDAOs.interfaces.LeadEditorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/leadEditors")
public class LeadEditorController extends HttpServlet  {

    private LeadEditorDAO leadEditorDAO;
    private EmployeeDAO employeeDAO;
    private UserService userService;

    @Override
    public void init() {
        leadEditorDAO = new LeadEditorDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
        userService = new UserService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getLeadEditors":
                getLeadEditors(request, response);
                break;
            case "getLeadEditor":
                getLeadEditor(request, response);
                break;
            case "deleteLeadEditor":
                deleteLeadEditor(request, response);
                getLeadEditors(request, response);
                break;
            case "editLeadEditor":
                editLeadEditor(request, response);
                getLeadEditors(request, response);
                break;
        }
    }

    private void getLeadEditors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<LeadEditor> leadEditors = leadEditorDAO.selectLeadEditors();
        request.setAttribute("leadEditors", leadEditors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employeePages/leadEditorPages/mainLeadEditorPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int leadEditorId = Integer.parseInt(request.getParameter("leadEditorId"));
        LeadEditor leadEditor = leadEditorDAO.selectLeadEditor(leadEditorId);
        request.setAttribute("leadEditor", leadEditor);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employeePages/leadEditorPages/editLeadEditorPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeDAO.selectEmployee(employeeId);
        int userId = employee.getUserID();
        userService.deleteUser(userId);
    }

    private void editLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int finishedProjectsAmount = Integer.parseInt(request.getParameter("finishedProjectsAmount"));
        String mainGenre = request.getParameter("mainGenre");
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        leadEditorDAO.updateLeadEditor(new LeadEditor(id, finishedProjectsAmount, mainGenre, employeeId));
    }
}
