package controller;

import model.beans.employees.User;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        userDAO = new UserDAOImplementation();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = getUserFromRequestAttributes(request);
        int id = userDAO.insertUser(user);
        user.setId(id);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("currentUserId", id);
        response.sendRedirect("view/employeeRegistration.jsp");
    }

    private User getUserFromRequestAttributes(HttpServletRequest request) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        System.out.println(role);
        return new User(username, email, password, role);
    }
}
