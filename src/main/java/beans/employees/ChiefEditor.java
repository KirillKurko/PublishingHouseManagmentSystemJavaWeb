package beans.employees;

public class ChiefEditor extends AdvancedEmployee {

    private int id;
    private int finishedProjectsAmount;

    public ChiefEditor() {
        super();
        id = 0;
        finishedProjectsAmount = 0;
    }

    public ChiefEditor(int id, int finishedProjectsAmount, Employee employee) {
        super(employee);
        this.id = id;
        this.finishedProjectsAmount = finishedProjectsAmount;
    }

    public ChiefEditor(int finishedProjectsAmount, Employee employee) {
        super(employee);
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
        return employee.getId();
    }

    public void setEmployeeID(int id) {
        employee.setId(id);
    }
}
