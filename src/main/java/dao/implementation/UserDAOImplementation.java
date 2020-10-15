package dao.implementation;

import beans.employees.User;
import dao.interfaces.UserDAO;
import utilities.DatabaseUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImplementation implements UserDAO {

    private static final String INSERT_USER = "INSERT INTO User(login, password, email, hash, activated) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE User SET login = ?, password = ?, email = ?, hash = ?, activated = ? WHERE id = ?;";
    private static final String SELECT_USER = "SELECT * FROM User WHERE id = ?;";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?;";

    @Override
    public void insertUser(User user) {
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getHash());
            preparedStatement.setBoolean(5, user.isActivated());
            preparedStatement.executeUpdate();
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getHash());
            preparedStatement.setBoolean(5, user.isActivated());
            preparedStatement.setInt(6, user.getId());
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String hash = resultSet.getString("hash");
                boolean activated = resultSet.getBoolean("activated");
                user = new User(id, login, password, email, hash, activated);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

}
