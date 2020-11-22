package controller.registrationServlets;

import controller.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;
    private int userId;
    private int employeeId;

    @Override
    public void init() {
        loginService = new LoginService();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/view/main.jsp";;
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        if (!getIdValues(login, password)) {
            path = "/view/errors/loginError.jsp";
        }
        setSessionAttributes(request);
        response.sendRedirect(request.getContextPath() + path);
    }

    private boolean getIdValues(String login, String password) {
        userId = loginService.getUserId(login, password);
        if (userId < 0) {
            return false;
        }
        employeeId = loginService.getEmployeeId(userId);
        return true;
    }

    private void setSessionAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userId", userId);
        session.setAttribute("employeeId", employeeId);
    }
}
