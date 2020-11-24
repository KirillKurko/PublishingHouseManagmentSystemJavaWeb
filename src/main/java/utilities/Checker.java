package utilities;

import model.beans.employees.User;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.UserDAO;

public class Checker {

    private static final UserDAO userDAO = new UserDAOImplementation();

    public static boolean checkUsernameValid(String login) {
        User user = userDAO.selectUserByLogin(login);
        return user == null;
    }
}
