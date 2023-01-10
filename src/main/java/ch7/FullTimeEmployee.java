package ch7;

public class FullTimeEmployee extends Employee{

    private long salary;

    public FullTimeEmployee(String name, long salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getSalary() {
        return salary;
    }
}
