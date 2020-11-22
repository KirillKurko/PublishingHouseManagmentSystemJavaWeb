package model.beans.employees.employeesImplementations;

public class LeadEditor {

    private int id;
    private int finishedProjectsAmount;
    private String mainGenre;
    private int employeeID;

    public LeadEditor() {
        super();
        id = 0;
        finishedProjectsAmount = 0;
        mainGenre = "";
        employeeID = 0;
    }

    public LeadEditor(int id, int finishedProjectsAmount, String mainGenre, int employeeID) {
        this.id = id;
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.mainGenre = mainGenre;
        this.employeeID = employeeID;
    }

    public LeadEditor(int finishedProjectsAmount, String mainGenre, int employeeID) {
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.mainGenre = mainGenre;
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

    public String getMainGenre() {
        return mainGenre;
    }

    public void setMainGenre(String mainGenre) {
        this.mainGenre = mainGenre;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
