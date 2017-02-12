package java8.function.primitives;


import java8.function.function.Employee;

import java.util.function.*;

public class PrimitiveFunctionsPart2 {

    Function<Integer,Employee> intToEmloyeeFunc1 = id -> new Employee();
    //Given primitive input, output is Employee
    IntFunction<Employee> primitiveIntToEmloyeeFunc2 = id -> new Employee();
    DoubleFunction<Employee> primitiveDoubleToEmployee = id -> new Employee();
    LongFunction<Employee> primitiveLongToEmployee = id -> new Employee();

    Function<Double,Integer> doubleToIntFunction = d -> d.intValue();
    //Primitive double to primitive int function
    DoubleToIntFunction primitiveDoubleToIntFunc = d -> new Double(d).intValue();
    LongToIntFunction primitiveLongToIntFunc = l -> new Long(l).intValue(); // similarly there are more such functions

    //Object to Primitive functions
    ToIntFunction<Employee> objectToPrimitiveFunc = emp -> emp.hashCode();

    public static void main(String[] args) {

    }

}
