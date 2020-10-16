package beans.employees.employeesImplementations;

public class ChiefEditor {

    private int id;
    private int finishedProjectsAmount;
    private int employeeID;

    public ChiefEditor() {
        super();
        id = 0;
        finishedProjectsAmount = 0;
        employeeID = 0;
    }

    public ChiefEditor(int id, int finishedProjectsAmount, int employeeID) {
        this.id = id;
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.employeeID = employeeID;
    }

    public ChiefEditor(int finishedProjectsAmount, int employeeID) {
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.employeeID = employeeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFinishedProjectsAmount() {
        return finishedProjectsAmount;
    }

    public void setFinishedProjectsAmount(int finishedProjectsAmount) {
        this.finishedProjectsAmount = finishedProjectsAmount;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
