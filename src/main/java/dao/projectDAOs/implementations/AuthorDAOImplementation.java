package dao.projectDAOs.implementations;

import beans.project.Author;
import dao.projectDAOs.interfaces.AuthorDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class AuthorDAOImplementation implements AuthorDAO {

    private static final String INSERT_AUTHOR = "INSERT INTO Author(name, surname) VALUES (?, ?);";
    private static final String UPDATE_AUTHOR  = "UPDATE Author SET name = ?, surname = ? WHERE id = ?;";
    private static final String SELECT_AUTHOR  = "SELECT * FROM Author WHERE id = ?;";
    private static final String DELETE_AUTHOR  = "DELETE FROM Author WHERE id = ?;";

    @Override
    public int insertAuthor(Author author) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_AUTHOR, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, author.getName());
            preparedStatement.setString(2, author.getSurname());
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
    public boolean updateAuthor(Author author) {
        return false;
    }

    @Override
    public Author selectAuthor(int id) {
        return null;
    }

    @Override
    public boolean deleteAuthor(int id) {
        return false;
    }
}
