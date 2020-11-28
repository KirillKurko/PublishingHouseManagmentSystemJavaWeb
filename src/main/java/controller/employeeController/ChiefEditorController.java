package controller.employeeController;

import controller.services.employeeServices.UserService;
import model.beans.employees.employeesImplementations.ChiefEditor;
import model.beans.employees.employeesImplementations.Employee;
import model.dao.userDAOs.implementations.ChiefEditorDAOImplementation;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.interfaces.ChiefEditorDAO;
import model.dao.userDAOs.interfaces.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chiefEditors")
public class ChiefEditorController extends HttpServlet {

    private UserService userService;
    private ChiefEditorDAO chiefEditorDAO;
    private EmployeeDAO employeeDAO;

    @Override
    public void init() {
        userService = new UserService();
        chiefEditorDAO = new ChiefEditorDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getChiefEditors":
                getChiefEditors(request, response);
                break;
            case "getChiefEditor":
                getChiefEditor(request, response);
                break;
            case "deleteChiefEditor":
                deleteChiefEditor(request, response);
                getChiefEditors(request, response);
                break;
            case "editChiefEditor":
                editChiefEditor(request, response);
                getChiefEditors(request, response);
                break;
        }
    }

    private void getChiefEditors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiefEditor> chiefEditors = chiefEditorDAO.selectChiefEditors();
        request.setAttribute("chiefEditors", chiefEditors);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employeePages/chiefEditorPages/mainChiefEditorPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int chiefEditorId = Integer.parseInt(request.getParameter("chiefEditorId"));
        ChiefEditor chiefEditor = chiefEditorDAO.selectChiefEditor(chiefEditorId);
        request.setAttribute("chiefEditor", chiefEditor);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employeePages/chiefEditorPages/editChiefEditorPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void deleteChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeDAO.selectEmployee(employeeId);
        int userId = employee.getUserID();
        userService.deleteUser(userId);
    }

    private void editChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int finishedProjectsAmount = Integer.parseInt(request.getParameter("finishedProjectsAmount"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        chiefEditorDAO.updateChiefEditor(new ChiefEditor(id, finishedProjectsAmount, employeeId));
    }
}
