package utilities;

import model.beans.employees.User;
import model.beans.project.Book;
import model.dao.projectDAOs.implementations.BookDAOImplementation;
import model.dao.projectDAOs.interfaces.BookDAO;
import model.dao.userDAOs.implementations.UserDAOImplementation;
import model.dao.userDAOs.interfaces.UserDAO;

public class Checker {

    private static final UserDAO userDAO = new UserDAOImplementation();
    private static final BookDAO bookDAO = new BookDAOImplementation();

    public static boolean checkUsernameValid(String login, int id) {
        User user = userDAO.selectUserByLogin(login);
        return user == null || id == user.getId();
    }

    public static boolean checkUsernameExists(String login) {
        User user = userDAO.selectUserByLogin(login);
        return user != null ;
    }

    public static boolean checkBookNameValid(String name) {
        Book book = bookDAO.selectBookByName(name);
        return book == null;
    }

    public static boolean checkBookNameExists(String name) {
        Book book = bookDAO.selectBookByName(name);
        return book != null;
    }
}