package java8.function.biFunction;


import java8.function.function.Employee;
import java8.function.function.Manager;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {

    //BiFunction<T,U,R>
    BiFunction<Employee,Manager,Employee> empManagerBiFunction = (emp,manager) -> emp.getManager().getPersonalAssistant();

    //Note: the andThen() method of BiFunction takes Function<R,V> instead of BiFunction<T,U,V>
    // and returns a new BiFunction
    Function<Employee,Employee> empManagerFunction = (emp) -> emp.getManager().getPersonalAssistant();

    public void testAndThen(Employee employe1, Manager manager){
        BiFunction<Employee,Manager,Employee> empManagerBiAndThenDemo = empManagerBiFunction.andThen(empManagerFunction);
        Employee pa = empManagerBiAndThenDemo.apply(employe1,manager);
        System.out.println(pa);
    }
}
