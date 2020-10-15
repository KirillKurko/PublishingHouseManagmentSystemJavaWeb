package beans.project;

public class Task {

    private int id;
    private String description;
    private int employeeID;

    public Task() {
        id = 0;
        description = "";
        employeeID = 0;
    }

    public Task(int id, String description, int employeeID) {
        this.id = id;
        this.description = description;
        this.employeeID = employeeID;
    }

    public Task(String description, int employeeID) {
        this.description = description;
        this.employeeID = employeeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
