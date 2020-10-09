package dao.implementation;

public class UserDAOImplementation {

    private static final String INSERT_USER = "INSERT INTO User(login, password, email, hash, activated) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE User SET login = ?, password = ?, email = ?, hash = ?, activated = ? WHERE id = ?;";
    private static final String SELECT_USER = "SELECT * FROM User WHERE id = ?;";
    private static final String DELETE_USER = "DELETE FROM User WHERE id = ?;";

}
