package ch7;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args){
        Employee[] employees = {
            new FullTimeEmployee("직원1", 5000000),
            new FullTimeEmployee("직원2", 4000000),
            new FullTimeEmployee("직원3", 3000000),
            new PartTimeEmployee("아르바이트1", 8910, 40),
            new PartTimeEmployee("아르바이트2", 9000, 20)};


            for(Employee employee : employees){
                double taxRate = getTaxRate();
                final Long cacluatedSalary = SalaryCalculator.calculate(employee.getSalary(), taxRate);
                System.out.printf("이름 : %s, 급여 : %d\n", employee.getName(), cacluatedSalary);
            }


    }

    private static double getTaxRate() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new CloseShieldInputStream(System.in)))){
            System.out.print("세율을 입력하세요 : ");
            return Double.parseDouble(br.readLine().trim());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
