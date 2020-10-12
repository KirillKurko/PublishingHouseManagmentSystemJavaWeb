package beans.employees.employeesImplementations;

public class ChiefEditor extends Employee {

    private int id;
    private int finishedProjectsAmount;

    public ChiefEditor() {
        super();
        id = 0;
        finishedProjectsAmount = 0;
    }

    public ChiefEditor(int id, int finishedProjectsAmount,
                       int employeeID,
                       String name, String surname,
                       int experience, double salary,
                       int userID) {
        super(employeeID, name, surname, experience, salary, userID);
        this.id = id;
        this.finishedProjectsAmount = finishedProjectsAmount;
    }

    public ChiefEditor(int finishedProjectsAmount,
                       int employeeID,
                       String name, String surname,
                       int experience, double salary,
                       int userID) {
        super(name, surname, experience, salary, userID);
        this.finishedProjectsAmount = finishedProjectsAmount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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
        return super.getId();
    }

    public void setEmployeeID(int id) {
        super.setId(id);
    }
}
