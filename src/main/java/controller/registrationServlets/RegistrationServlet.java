package controller.registrationServlets;

import controller.services.RegistrationService;
import model.beans.employees.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private RegistrationService registrationService;

    @Override
    public void init() {
        registrationService = new RegistrationService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = registrationService.registerUser(request, response);
        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("role", user.getRole());
        response.sendRedirect(request.getContextPath() + "/view/registration/employeeRegistration.jsp");
    }
}
