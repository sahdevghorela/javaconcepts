package java8.function.biConsumer;


import java8.function.function.Employee;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerDemo {

    BiConsumer<Employee,Integer> empBonusConsumer =
            (emp,bonus) -> System.out.printf("Employee %s is set for %s pct of bonus",emp,bonus);
    BiConsumer<Employee,Integer> empSalaryHikeConsumer =
            (emp,salaryHike) -> System.out.printf("Employee %s is having %s pct salary hike",emp,salaryHike);

    BiConsumer<Employee,Integer> empBonusAndSalaryHikeConsumer = empBonusConsumer.andThen(empSalaryHikeConsumer);

    public void testBiPredicate(Employee employee,Integer bonus, Integer salaryHike){
        empBonusConsumer.accept(employee,bonus);
        empSalaryHikeConsumer.accept(employee,salaryHike);

    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        new BiConsumerDemo().testBiPredicate(employee,15,5);

    }
}
