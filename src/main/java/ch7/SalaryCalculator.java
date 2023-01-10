package ch7;

public class SalaryCalculator {

    public static Long calculate(Long salary, Double taxRate){
        return Math.round(salary * (100 - taxRate) / 100);
    }

}
