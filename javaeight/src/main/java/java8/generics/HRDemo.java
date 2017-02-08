package java8.generics;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class HRDemo {

    public void printEmployees(List<Employee> employees){
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public void printEmployeesAndSubTypes(List<? extends Employee> employees){
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        // Does not compile. employees.add(new Employee("name"));
        // Does not compile. employees.add(new Salaried("name",100));
    }

    public void printAllEmployeesWithFilter(List<? extends Employee> employees, Predicate<? super Employee> predicate){
        employees.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("AName"), new Employee("BB"));
        List<Salaried> salarieds = Arrays.asList(new Salaried("CSalaried",1000), new Salaried("DSalar"));

        HRDemo hrDemo = new HRDemo();

        hrDemo.printEmployees(employees);
        // Does not compile. hrDemo.printEmployees(salarieds);

        hrDemo.printEmployeesAndSubTypes(salarieds);

        hrDemo.printAllEmployeesWithFilter(salarieds, employee -> employee.getName().length()%2==1);

        //Rule: PECS - Producers uses extends, Consumers uses Super

    }
}
