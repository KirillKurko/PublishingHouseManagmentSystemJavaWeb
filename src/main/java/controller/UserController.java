package controller;

import controller.services.userServices.UserService;
import model.beans.employees.User;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.UserDAO;
import utilities.Checker;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserController extends HttpServlet {

    private UserDAO userDAO;
    private UserService userService;

    @Override
    public void init() {
        userDAO = new UserDAOImplementation();
        userService = new UserService();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("action");
        switch (method) {
            case "getUsers":
                getUsers(request, response);
                break;
            case "deleteUser":
                deleteUser(request, response);
                getUsers(request, response);
                break;
            case "getUser":
                getUser(request, response);
                break;
            case "editUser":
                editUser(request, response);
                getUsers(request, response);
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        userService.deleteUser(userId);
    }

    private void getUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO.selectUsers();
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/userPages/mainUserPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDAO.selectUser(userId);
        request.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/userPages/editUserPage.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        if (Checker.checkUsernameValid(login)) {
            userDAO.updateUser(new User(id, login, password, email, role));
        }
    }
}
