package model.dao.projectDAOs.implementations;

import model.beans.project.Review;
import model.dao.projectDAOs.interfaces.ReviewDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImplementation implements ReviewDAO  {

    private static final String INSERT_REVIEW = "INSERT INTO Review(rating, description, bookName, bookID) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_REVIEW = "UPDATE Review SET rating = ?, description = ?, bookName = ?, bookID = ? WHERE id = ?;";
    private static final String UPDATE_REVIEW_BOOK_NAME_BY_BOOK_ID = "UPDATE Review SET bookName = ? WHERE bookID = ?";
    private static final String SELECT_REVIEW = "SELECT * FROM Review WHERE id = ?;";
    private static final String SELECT_REVIEWS = "SELECT * FROM Review;";
    private static final String SELECT_REVIEW_BY_BOOK_ID = "SELECT * FROM Review WHERE bookID = ?;";
    private static final String DELETE_REVIEW = "DELETE FROM Review WHERE id = ?;";
    private static final String DELETE_REVIEW_BY_BOOK_ID = "DELETE FROM Review WHERE bookID = ?;";

    @Override
    public int insertReview(Review review) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_REVIEW, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, review.getRating());
            preparedStatement.setString(2, review.getDescription());
            preparedStatement.setString(3, review.getBookName());
            preparedStatement.setInt(4, review.getBookID());
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
            preparedStatement.setString(3, review.getBookName());
            preparedStatement.setInt(4, review.getBookID());
            preparedStatement.setInt(5, review.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean updateReviewsBookNameByBookId(String bookName, int bookId) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REVIEW_BOOK_NAME_BY_BOOK_ID)) {
            preparedStatement.setString(1, bookName);
            preparedStatement.setInt(2, bookId);
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
                String bookName = resultSet.getString("bookName");
                int bookID = resultSet.getInt("bookID");
                review = new Review(id, rating, description, bookName, bookID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return review;
    }

    @Override
    public List<Review> selectReviewsByBookId(int bookId) {
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_BOOK_ID)) {
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int rating = resultSet.getInt("rating");
                String description = resultSet.getString("description");
                String bookName = resultSet.getString("bookName");
                reviews.add(new Review(id, rating, description, bookName, bookId));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<Review> selectReviews() {
        List<Review> reviews = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEWS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int rating = resultSet.getInt("rating");
                String description = resultSet.getString("description");
                String bookName = resultSet.getString("bookName");
                int bookID = resultSet.getInt("bookID");
                reviews.add(new Review(id, rating, description, bookName, bookID));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return reviews;
    }

    @Override
    public boolean deleteReview(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REVIEW)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }


    @Override
    public boolean deleteReviewByBookId(int bookId) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_REVIEW_BY_BOOK_ID)) {
            preparedStatement.setInt(1, bookId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
