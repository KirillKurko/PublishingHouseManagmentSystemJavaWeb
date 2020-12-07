package model.dao.projectDAOs.implementations;

import model.beans.project.Project;
import model.dao.projectDAOs.interfaces.ProjectDAO;
import utilities.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImplementation implements ProjectDAO {

    private static final String INSERT_PROJECT = "INSERT INTO Project(pagesAmount, pagePrice, booksAmount, leadEditorID, bookID) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_PROJECT = "UPDATE Project SET pagesAmount = ?, pagePrice = ?, booksAmount = ?, leadEditorID = ?, bookID = ? WHERE id = ?;";
    private static final String SELECT_PROJECT = "SELECT * FROM Project WHERE id = ?;";
    private static final String SELECT_PROJECTS = "SELECT * FROM Project;";
    private static final String DELETE_PROJECT = "DELETE FROM Project WHERE id = ?;";

    @Override
    public int insertProject(Project project) {
        int id = 0;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, project.getPagesAmount());
            preparedStatement.setDouble(2, project.getPagePrice());
            preparedStatement.setInt(3, project.getBooksAmount());
            preparedStatement.setInt(4, project.getLeadEditorId());
            preparedStatement.setInt(5, project.getBookId());
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
    public boolean updateProject(Project project) {
        boolean rowUpdated = false;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT)) {
            preparedStatement.setInt(1, project.getPagesAmount());
            preparedStatement.setDouble(2, project.getPagePrice());
            preparedStatement.setInt(3, project.getBooksAmount());
            preparedStatement.setInt(4, project.getLeadEditorId());
            preparedStatement.setInt(5, project.getBookId());
            preparedStatement.setInt(6, project.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public Project selectProject(int id) {
        Project project = null;
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECT)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int pagesAmount = resultSet.getInt("pagesAmount");
                double pagePrice = resultSet.getInt("pagePrice");
                int booksAmount = resultSet.getInt("booksAmount");
                int leadEditorId = resultSet.getInt("leadEditorID");
                int bookId = resultSet.getInt("bookID");
                project = new Project(id, pagesAmount, pagePrice, booksAmount, leadEditorId, bookId);
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> selectProjects() {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PROJECTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int pagesAmount = resultSet.getInt("pagesAmount");
                double pagePrice = resultSet.getInt("pagePrice");
                int booksAmount = resultSet.getInt("booksAmount");
                int leadEditorId = resultSet.getInt("leadEditorID");
                int bookId = resultSet.getInt("bookID");
                projects.add(new Project(id, pagesAmount, pagePrice, booksAmount, leadEditorId, bookId));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return projects;
    }

    @Override
    public boolean deleteProject(int id) {
        boolean rowDeleted = false;
        try (Connection connection = DatabaseUtility.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJECT)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return rowDeleted;
    }
}
