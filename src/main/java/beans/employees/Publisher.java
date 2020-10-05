package beans.employees;

public class Publisher extends AdvancedEmployee {

    private int id;
    private double finances;
    private int employeeID;

    public Publisher() {
        super();
        id = 0;
        finances = 0.0;
        employeeID = 0;
    }

    public Publisher(int id, double finances, int employeeID, Employee employee) {
        super(employee);
        this.id = id;
        this.finances = finances;
        this.employeeID = employeeID;
    }

    public Publisher(double finances, int employeeID, Employee employee) {
        super(employee);
        this.finances = finances;
        this.employeeID = employeeID;
    }

    public double getFinances() {
        return finances;
    }

    public void setFinances(double finances) {
        this.finances = finances;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
