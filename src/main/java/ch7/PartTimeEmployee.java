package ch7;

public class PartTimeEmployee extends Employee{

    private long hourly; // 시급
    private int monthlyTime; // 달에 일하는 시간

    public PartTimeEmployee(String name, long hourly, int monthlyTime) {
        super(name);
        this.hourly = hourly;
        this.monthlyTime = monthlyTime;
    }

    @Override
    public long getSalary() {
        return hourly * monthlyTime;
    }
}
