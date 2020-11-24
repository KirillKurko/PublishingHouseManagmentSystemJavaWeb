package controller.services;

import model.beans.employees.User;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.UserDAO;
import utilities.Checker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationService {

    private final UserDAO userDAO;

    public RegistrationService() {
        userDAO = new UserDAOImplementation();
    }

    public User registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getUserFromRequest(request);
        while (!Checker.checkUsernameValid(user.getLogin())) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/registration/registrationPage.jsp");
            requestDispatcher.forward(request, response);
        }
        int id = userDAO.insertUser(user);
        user.setId(id);
        return user;
    }

    public User getUserFromRequest(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        return new User(username, password, email, role);
    }

}
