package controller.registrationServlets;

import controller.services.RegistrationService;
import model.beans.employees.User;
import model.beans.employees.employeesImplementations.Employee;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/registration", "/add"})
public class RegistrationServlet extends HttpServlet {

    private RegistrationService registrationService;
    private String urlPattern;

    @Override
    public void init() {
        registrationService = new RegistrationService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        String path = "";
        switch (method) {
            case "registerUser":
                urlPattern = request.getRequestURI().substring(request.getContextPath().length());
                registerUser(request, response);
                path = "/view/registration/employeeRegistration.jsp";
                break;
            case "registerEmployee":
                registerEmployee(request, response);
                path = getPath(request);
                break;
            case "registerPublisher":
                registerPublisher(request, response);
                break;
            case "registerLeadEditor":
                registerLeadEditor(request, response);
                break;
            case "registerChiefEditor":
                registerChiefEditor(request, response);
                break;
        }
        if (path.equals("")) {
            path = urlPattern.equals("/registration") ? "/view/main.jsp" : "/users?action=getUsers";
        }
        response.sendRedirect(request.getContextPath() + path);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = registrationService.registerUser(request, response);
        if (urlPattern.equals("/registration")) {
            setSessionUserAttributes(request, user);
        }
        request.getSession().setAttribute("addRole", user.getRole());
        request.getSession().setAttribute("addUserId", user.getId());
    }

    private void registerEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee employee = registrationService.registerEmployee(request, response);
        if (urlPattern.equals("/registration")) {
            setSessionEmployeeAttributes(request, employee);
        }
        request.getSession().setAttribute("addEmployeeId", employee.getId());
    }

    public void registerPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registrationService.registerPublisher(request, response);
    }

    public void registerLeadEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registrationService.registerLeadEditor(request, response);
    }

    public void registerChiefEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registrationService.registerChiefEditor(request, response);
    }

    private String getPath(HttpServletRequest request) {
        String path = "/view/main.jsp";
        String role;
        if (urlPattern.equals("/registration")) {
            role = (String) request.getSession().getAttribute("role");
        }
        else {
            role = (String) request.getSession().getAttribute("addRole");
        }
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

    private void setSessionUserAttributes(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("role", user.getRole());
    }

    private void setSessionEmployeeAttributes(HttpServletRequest request, Employee employee) {
        HttpSession session = request.getSession();
        session.setAttribute("employeeId", employee.getId());
    }
}
