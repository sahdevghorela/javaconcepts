package java8.streams.grouping;


import java8.function.function.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingByDemo {
    private List<Employee> employees = Arrays.asList(new Employee(),new Employee());

    private void groupingByDepartmentOfEmployee(){
       Map<String,List<Employee>> empsGroupedByDept =  employees.stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));

    }

    private void groupByDeptAndCity(){
      Map<String,Map<String,List<Employee>>> empsGroupdByDeptAndCity =   employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy(Employee::getCity)));
    }
}
