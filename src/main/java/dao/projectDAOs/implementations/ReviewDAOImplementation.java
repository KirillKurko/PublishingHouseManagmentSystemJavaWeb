package dao.projectDAOs.implementations;

import beans.project.Review;
import dao.projectDAOs.interfaces.ReviewDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class ReviewDAOImplementation implements ReviewDAO  {

    private static final String INSERT_REVIEW = "INSERT INTO Review(rating, description, bookID) VALUES (?, ?, ?);";
    private static final String UPDATE_REVIEW  = "UPDATE Review SET rating = ?, description = ?, bookID = ? WHERE id = ?;";
    private static final String SELECT_REVIEW  = "SELECT * FROM Review WHERE id = ?;";
    private static final String DELETE_REVIEW  = "DELETE FROM Review WHERE id = ?;";

    @Override
    public int insertReview(Review review) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEW, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, review.getRating());
            preparedStatement.setString(2, review.getDescription());
            preparedStatement.setInt(3, review.getBookID());
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
    public boolean updateReview(Review review) {
        return false;
    }

    @Override
    public Review selectReview(int id) {
        return null;
    }

    @Override
    public boolean deleteReview(int id) {
        return false;
    }
}
