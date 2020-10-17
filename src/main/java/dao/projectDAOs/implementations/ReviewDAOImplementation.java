package dao.projectDAOs.implementations;

import beans.project.Review;
import dao.projectDAOs.interfaces.ReviewDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class ReviewDAOImplementation implements ReviewDAO  {

    private static final String INSERT_REVIEW = "INSERT INTO Review(rating, description, bookID) VALUES (?, ?, ?);";
    private static final String UPDATE_REVIEW = "UPDATE Review SET rating = ?, description = ?, bookID = ? WHERE id = ?;";
    private static final String SELECT_REVIEW = "SELECT * FROM Review WHERE id = ?;";
    private static final String DELETE_REVIEW = "DELETE FROM Review WHERE id = ?;";

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
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEW)) {
            preparedStatement.setInt(1, review.getRating());
            preparedStatement.setString(2, review.getDescription());
            preparedStatement.setInt(3, review.getBookID());
            preparedStatement.setInt(4, review.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Review selectReview(int id) {
        Review review = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rating = resultSet.getInt("rating");
                String description = resultSet.getString("description");
                int bookID = resultSet.getInt("bookID");
                review = new Review(id, rating, description, bookID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return review;
    }

    @Override
    public boolean deleteReview(int id) {
        return false;
    }
}
