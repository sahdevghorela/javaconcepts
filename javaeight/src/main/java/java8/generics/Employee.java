package java8.generics;


public class Employee {

    private String name;

    public Employee(String name){
        this.name = name;
    }

    public String toString(){
        return "Employee name="+name;
    }

    public String getName(){
        return name;
    }
}
