package java8.streams;


import java8.function.function.Employee;

import java.util.Optional;

public class OptionalDemo {

    private void filterOptionalDemo(){
        Employee employee = new Employee();
        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);

        Optional<Employee> filteredEmployee = optionalEmployee.filter(emp -> emp.getManager()!=null);

        filteredEmployee.ifPresent(System.out::println);
    }

    private void mapOptionalDemo(){

        Optional<String> optionalName = Optional.ofNullable(new Employee())
                .filter(emp -> emp.getManager() != null)
                .map(emp -> emp.getManager().toString());

        optionalName.ifPresent(System.out::println);

    }

    private void orElseDemo(){
        Employee defaultEmp = new Employee();

        Optional<Employee> employee = Optional.of(new Employee());

        String name = employee.orElse(defaultEmp).getManager().toString();

        System.out.println(name);
    }

    private void orElseThrowDemo(){
        Optional<Employee> employee = Optional.of(new Employee());

        String name = employee.orElseThrow(IllegalStateException::new).toString();
        System.out.println(name);
    }
}
