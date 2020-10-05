package beans.employees;

abstract public class AdvancedEmployee implements EmployeeInterface {

    protected Employee employee;

    public AdvancedEmployee() {
        employee = null;
    }

    public AdvancedEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public void setName(String name) {
        employee.setName(name);
    }

    @Override
    public String getSurname() {
        return employee.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        employee.setSurname(surname);
    }

    @Override
    public int getExperience() {
        return employee.getExperience();
    }

    @Override
    public void setExperience(int experience) {
        employee.setExperience(experience);
    }

    @Override
    public double getSalary() {
        return employee.getSalary();
    }

    @Override
    public void setSalary(double salary) {
        employee.setSalary(salary);
    }

    @Override
    public int getUserID() {
        return employee.getUserID();
    }

    @Override
    public void setUserID(int userID) {
        employee.setUserID(userID);
    }
}
