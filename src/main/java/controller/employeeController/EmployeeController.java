package controller.employeeController;

import controller.services.EditService;
import controller.services.employeeServices.UserService;
import model.beans.employees.employeesImplementations.Employee;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.interfaces.EmployeeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeController extends HttpServlet {

    private EmployeeDAO employeeDAO;
    private UserService userService;
    private EditService editService;

    @Override
    public void init() {
        employeeDAO = new EmployeeDAOImplementation();
        userService = new UserService();
        editService = new EditService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getEmployees":
                getEmployees(request, response);
                break;
            case "getEmployee":
                getEmployee(request, response);
                break;
            case "editEmployee":
                editEmployee(request, response);
                getEmployees(request, response);
                break;
            case "deleteEmployee":
                deleteEmployee(request, response);
                getEmployees(request, response);
                break;
        }
    }

    private void getEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeDAO.selectEmployees();
        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employeePages/employeePages/mainEmployeePage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        Employee employee = employeeDAO.selectEmployee(employeeId);
        request.setAttribute("employee", employee);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employeePages/employeePages/editEmployeePage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editService.editEmployee(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        userService.deleteUser(userId);
    }
}
