package EmployeesSalaryAnalysis;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getSalary(){
        return salary;
    }

    @Override
    public String toString(){
        //return "Name:"+ name + ", Age:"+ age + ", Salary:$" + salary+ "/year";
        return String.format("{name:%s, age:%d, salary:$%.2f}", name, age, salary);
    }
}

public class EmployeesSalary {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Peter", 29, 50000));
        employees.add(new Employee("Jenesis", 35, 55000));
        employees.add(new Employee("James", 40, 100000));
        employees.add(new Employee("Bruce", 20, 30000));
        employees.add(new Employee("Peter", 40, 250000));
        employees.add(new Employee("Jane", 56, 350000));

        //Created list of employees:
        System.out.println("Employees list:");
        System.out.println(employees);

        //List of employees who earn more than 100,000 per year
        System.out.println("Who earn more than 100k?");
        List<Employee> empList = employees.stream()
                                          .filter(employee->employee.getSalary()>100000)
                                          .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(empList);

        //Calculate Average salary of the employees over 30 years old
        System.out.println("Average salary:");
        double average = employees.stream()
                .filter(employee->employee.getAge()>30)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println("$"+average);

        //Updated employee list with 10% Salary increase
        System.out.println("Updated list:");
        List<Employee> salaryUpdate = employees.stream()
                                                .map(employee-> new Employee(employee.getName(), employee.getAge(), employee.getSalary()*1.1))
                                                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(salaryUpdate);

    }
}
