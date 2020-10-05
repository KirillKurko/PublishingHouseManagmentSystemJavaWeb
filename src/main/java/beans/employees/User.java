package beans.employees;

public class User {

    private int id;
    private String login;
    private String password;
    private String email;
    private String hash;
    private boolean activated;

    public User() {
        id = 0;
        login = "";
        password = "";
        email = "";
        hash = "";
        activated = false;
    }

    public User(int id, String login, String password, String email, String hash, boolean activated) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.hash = hash;
        this.activated = activated;
    }

    public User(String login, String password, String email, String hash, boolean activated) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.hash = hash;
        this.activated = activated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
