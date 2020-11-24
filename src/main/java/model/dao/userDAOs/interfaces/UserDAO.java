package model.dao.userDAOs.interfaces;

import model.beans.employees.User;

import java.util.List;

public interface UserDAO {

    int insertUser(User user);

    void updateUser(User user);

    User selectUser(int id);

    User selectUserByLogin(String login);

    List<User> selectUsers();

    void deleteUser(int id);
}
