package controller.registrationServlets;

import controller.services.RegistrationService;
import model.beans.employees.employeesImplementations.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration/employeeInformation")
public class EmployeeRegistrationServlet extends HttpServlet {

    private RegistrationService registrationService;

    @Override
    public void init() {
        registrationService = new RegistrationService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = registrationService.registerEmployee(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("employeeId", employee.getId());
        session.setAttribute("employee", employee);
        String path = getPath(request);
        response.sendRedirect(request.getContextPath() + path);
    }

    private String getPath(HttpServletRequest request) {
        String path = "/view/main.jsp";
        String role = (String) request.getSession().getAttribute("role");
        switch (role) {
            case "publisher":
                path = "/view/registration/publisherRegistration.jsp";
                break;
            case "chiefEditor":
                path = "/view/registration/chiefEditorRegistration.jsp";
                break;
            case "leadEditor":
                path = "/view/registration/leadEditorRegistration.jsp";
                break;
        }
        return path;
    }
}
