package dao.userDAOs.implementations;

import beans.employees.User;
import dao.userDAOs.interfaces.UserDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class UserDAOImplementation implements UserDAO {

    private static final String INSERT_USER = "INSERT INTO User(login, password, email, hash, activated) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE User SET login = ?, password = ?, email = ?, hash = ?, activated = ? WHERE id = ?;";
    private static final String SELECT_USER = "SELECT * FROM User WHERE id = ?;";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?;";

    @Override
    public int insertUser(User user) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getHash());
            preparedStatement.setBoolean(5, user.isActivated());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return id;
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
            rowUpdated = preparedStatement.executeUpdate() > 0;
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
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }

}
