package dao.userDAOs.implementation;

import beans.employees.employeesImplementations.Publisher;
import dao.userDAOs.interfaces.PublisherDAO;
import utilities.DatabaseUtility;

import java.sql.*;

public class PublisherDAOImplementation implements PublisherDAO  {

    private static final String INSERT_PUBLISHER = "INSERT INTO Publisher(finances, employeeID) VALUES (?, ?);";
    private static final String UPDATE_PUBLISHER = "UPDATE Publisher SET finances = ?, employeeID = ? WHERE id = ?;";
    private static final String SELECT_PUBLISHER = "SELECT * FROM Publisher WHERE id = ?;";
    private static final String DELETE_PUBLISHER = "DELETE FROM Publisher WHERE id = ?;";

    @Override
    public int insertPublisher(Publisher publisher) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PUBLISHER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDouble(1, publisher.getFinances());
            preparedStatement.setInt(2, publisher.getEmployeeID());
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
    public boolean updatePublisher(Publisher publisher) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PUBLISHER)) {
            preparedStatement.setDouble(1, publisher.getFinances());
            preparedStatement.setInt(2, publisher.getEmployeeID());
            preparedStatement.setInt(3, publisher.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Publisher selectPublisher(int id) {
        Publisher publisher = null;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PUBLISHER)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                double finances = resultSet.getDouble("finances");
                int employeeID = resultSet.getInt("employeeID");
                publisher = new Publisher(id, finances, employeeID);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return publisher;
    }

    @Override
    public boolean deletePublisher(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PUBLISHER)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
