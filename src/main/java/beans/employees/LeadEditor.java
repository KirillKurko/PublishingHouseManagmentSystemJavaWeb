package beans.employees;

public class LeadEditor extends AdvancedEmployee {

    private int id;
    private int finishedProjectsAmount;
    private String mainGenre;

    public LeadEditor() {
        super();
        id = 0;
        finishedProjectsAmount = 0;
        mainGenre = "";
    }

    public LeadEditor(int id, int finishedProjectsAmount, String mainGenre, Employee employee) {
        super(employee);
        this.id = id;
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.mainGenre = mainGenre;
        this.employee = employee;
    }

    public LeadEditor(int finishedProjectsAmount, String mainGenre, Employee employee) {
        super(employee);
        this.finishedProjectsAmount = finishedProjectsAmount;
        this.mainGenre = mainGenre;
        this.employee = employee;
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
        return employee.getId();
    }

    public void setEmployeeID(int id) {
        employee.setId(id);
    }
}
