package controller.services;

import model.beans.employees.User;
import model.beans.employees.employeesImplementations.Employee;
import model.dao.userDAOs.implementations.EmployeeDAOImplementation;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.EmployeeDAO;
import model.dao.userDAOs.interfaces.UserDAO;

public class LoginService {

    private final UserDAO userDAO;
    private final EmployeeDAO employeeDAO;
    private User user;

    public LoginService() {
        userDAO = new UserDAOImplementation();
        employeeDAO = new EmployeeDAOImplementation();
    }

    public int getEmployeeId(int userId) {
        System.out.println("userId: " + userId);
        Employee employee = employeeDAO.selectEmployeeByUserId(userId);
        return employee.getId();
    }

    public int getUserId(String login, String password) {
        if (checkUser(login, password)) {
            return user.getId();
        }
        return -1;
    }

    public String getRole() {
        return user.getRole();
    }

    private boolean checkUser(String loginAttempt, String passwordAttempt) {
        user = userDAO.selectUserByLogin(loginAttempt);
        if (user == null) {
            return false;
        }
        return checkPassword(passwordAttempt);
    }

    private boolean checkPassword(String passwordAttempt) {
        String password = user.getPassword();
        return password.equals(passwordAttempt);
    }
}
