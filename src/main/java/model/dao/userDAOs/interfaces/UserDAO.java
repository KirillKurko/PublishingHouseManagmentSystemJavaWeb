package model.dao.userDAOs.interfaces;

import model.beans.employees.User;

public interface UserDAO {

    int insertUser(User user);

    boolean updateUser(User user);

    User selectUser(int id);

    boolean deleteUser(int id);
}
