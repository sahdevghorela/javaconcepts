package java8.streams.partitioning;


import java8.function.function.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPartitioningDemo {

    private List<Employee> employees = Arrays.asList(new Employee(),new Employee());

    private void partitioningByExecutive(){
        Map<Boolean,List<Employee>> partitionedByExec = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isExecutive));
    }

    private void partitioningByAndGroupingBy(){
       Map<Boolean,Map<String,List<Employee>>> partitionedByExeAndGroupedByDept =  employees.stream()
                .collect(Collectors.partitioningBy(Employee::isExecutive,Collectors.groupingBy(Employee::getDepartment)));
    }

    private void multilevelPartitioning(){
        Map<Boolean,Map<Boolean,List<Employee>>> multilevelPartitioning = employees.stream()
                .collect(Collectors.partitioningBy(Employee::isExecutive,Collectors.partitioningBy(Employee::isSenior)));
    }

}
