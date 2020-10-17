import beans.employees.User;
import dao.userDAOs.implementations.UserDAOImplementation;
import dao.userDAOs.interfaces.UserDAO;

public class mainTest {

    public static void main(String[] args) {

        User user = new User();
        UserDAO userDAO = new UserDAOImplementation();
        int id = userDAO.insertUser(user);
        System.out.println("ID: " + id);
    }
}
