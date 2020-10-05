package beans.employees;

public class Publisher extends AdvancedEmployee {

    private int id;
    private double finances;

    public Publisher() {
        super();
        id = 0;
        finances = 0.0;
    }

    public Publisher(int id, double finances, int employeeID, Employee employee) {
        super(employee);
        this.id = id;
        this.finances = finances;
    }

    public Publisher(double finances, int employeeID, Employee employee) {
        super(employee);
        this.finances = finances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFinances() {
        return finances;
    }

    public void setFinances(double finances) {
        this.finances = finances;
    }

    public int getEmployeeID() {
        return employee.getId();
    }

    public void setEmployeeID(int id) {
        employee.setId(id);
    }
}
