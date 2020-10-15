package dao.interfaces;

import beans.employees.User;

public interface UserDAO {

    void insertUser(User user);

    void updateUser(User user);

    User selectUser(int id);

    boolean deleteUser(int id);
}
