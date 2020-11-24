package controller.registrationServlets;

import controller.services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registration/employeeInformation/chiefEditor")
public class ChiefEditorRegistrationServlet extends HttpServlet {

    private RegistrationService registrationService;

    @Override
    public void init() {
        registrationService = new RegistrationService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
