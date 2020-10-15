package dao.interfaces;

import beans.employees.User;

public interface UserDAO {

    void insertUser(User user);

    boolean updateUser(User user);

    User selectUser(int id);

    boolean deleteUser(int id);
}
