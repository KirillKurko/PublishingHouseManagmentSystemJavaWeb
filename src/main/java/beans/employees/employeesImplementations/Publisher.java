package beans.employees.employeesImplementations;

public class Publisher extends Employee {

    private int id;
    private double finances;

    public Publisher() {
        super();
        id = 0;
        finances = 0.0;
    }

    public Publisher(int id, double finances,
                     int employeeID,
                     String name, String surname,
                     int experience, double salary,
                     int userID) {
        super(employeeID, name, surname, experience, salary, userID);
        this.id = id;
        this.finances = finances;
    }

    public Publisher(double finances, int employeeID,
                     String name, String surname,
                     int experience, double salary,
                     int userID) {
        super(employeeID, name, surname, experience, salary, userID);
        this.finances = finances;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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
        return super.getId();
    }

    public void setEmployeeID(int id) {
        super.setId(id);
    }
}
