package controller.registrationServlets;

import model.beans.employees.employeesImplementations.Employee;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.interfaces.EmployeeDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration/employeeInformation")
public class EmployeeRegistrationServlet extends HttpServlet {

    private EmployeeDAO employeeDAO;

    @Override
    public void init() {
        employeeDAO = new EmployeeDAOImplementation();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = getEmployeeFromRequest(request);
        int id = employeeDAO.insertEmployee(employee);
        employee.setId(id);
        HttpSession session = request.getSession();
        session.setAttribute("employeeId", id);
        session.setAttribute("employee", employee);
        response.sendRedirect(request.getContextPath() + "/view/main.jsp");
    }

    private Employee getEmployeeFromRequest(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int experience = Integer.parseInt(request.getParameter("experience"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        int userId = (int) request.getSession().getAttribute("userId");
        return new Employee(name, surname, experience, salary, userId);
    }

}
