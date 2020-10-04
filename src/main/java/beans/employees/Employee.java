package beans.employees;

public class Employee {

    private int id;
    private String name;
    private String surname;
    private int experience;
    private double salary;
    private int userID;

    public Employee() {
        id = 0;
        name = "";
        surname = "";
        experience = 0;
        salary = 0.0;
        userID = 0;
    }

    public Employee(int id, String name, String surname, int experience, double salary, int userID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.salary = salary;
        this.userID = userID;
    }

    public Employee(String name, String surname, int experience, double salary, int userID) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.salary = salary;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
