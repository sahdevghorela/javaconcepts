package java8.function.biPredicate;


import java8.function.function.Employee;
import java8.function.function.Manager;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

    BiPredicate<Employee,Manager> employeeHasManager =
            (emp,manager) -> manager.equals(emp.getManager());
    BiPredicate<Employee,Manager> managerHasPersonalAssistant =
            (emp,manager) -> manager.getPersonalAssistant().equals(emp);

    BiPredicate<Employee,Manager> empIsPAOfManger = employeeHasManager.and(managerHasPersonalAssistant);
    BiPredicate<Employee,Manager> empIsPAOrHasManager = employeeHasManager.or(managerHasPersonalAssistant);

    BiPredicate<Employee,Manager> employeeNotHasManager = employeeHasManager.negate();

    public static void main(String[] args) {
        BiPredicateDemo demo = new BiPredicateDemo();

        boolean isEmpHasManager = demo.employeeHasManager.test(new Employee(),new Manager());
        System.out.println(isEmpHasManager);
    }
}
