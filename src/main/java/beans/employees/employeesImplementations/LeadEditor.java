package beans.employees.employeesImplementations;

public class LeadEditor extends Employee {

    private int id;
    private int finishedProjectsAmount;
    private String mainGenre;

    public LeadEditor() {
        super();
        id = 0;
        finishedProjectsAmount = 0;
        mainGenre = "";
    }

    public LeadEditor(int id, int finishedProjectsAmount, String mainGenre,
                      int employeeID,
                      String name, String surname,
                      int experience, double salary,
                      int userID) {
        super(employeeID, name, surname, experience, salary, userID);
        this.id = id;
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.mainGenre = mainGenre;
    }

    public LeadEditor(int finishedProjectsAmount, String mainGenre,
                      int employeeID,
                      String name, String surname,
                      int experience, double salary,
                      int userID) {
        super(employeeID, name, surname, experience, salary, userID);
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.mainGenre = mainGenre;
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

    public String getMainGenre() {
        return mainGenre;
    }

    public void setMainGenre(String mainGenre) {
        this.mainGenre = mainGenre;
    }

    public int getEmployeeID() {
        return super.getId();
    }

    public void setEmployeeID(int id) {
        super.setId(id);
    }
}
