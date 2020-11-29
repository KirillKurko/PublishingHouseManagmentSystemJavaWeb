package model.beans.project;

public class Task {

    private int id;
    private String name;
    private String description;
    private String customerName;
    private String executorName;
    private int employeeID;

    public Task() {
        id = 0;
        name = "";
        description = "";
        employeeID = 0;
    }

    public Task(int id, String name, String description, String customerName, String executorName, int employeeID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.customerName = customerName;
        this.executorName = executorName;
        this.employeeID = employeeID;
    }

    public Task(String name, String description, String customerName, String executorName, int employeeID) {
        this.name = name;
        this.description = description;
        this.customerName = customerName;
        this.executorName = executorName;
        this.employeeID = employeeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
