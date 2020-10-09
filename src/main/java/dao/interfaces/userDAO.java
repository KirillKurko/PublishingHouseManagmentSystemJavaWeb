package dao.interfaces;

import beans.employees.User;

public interface userDAO {

    void insertUser(User user);

    void updateUser(User user);

    public User selectUser(int id);

    public boolean deleteUser(int id);
}
