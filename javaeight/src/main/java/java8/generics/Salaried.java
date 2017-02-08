package java8.generics;


public class Salaried extends Employee{

    private static final int DEFAULT_SALARY = 12000;

    private int salary;

    public Salaried(String name) {
        this(name,DEFAULT_SALARY);
    }

    public Salaried(String name, int salary){
        super(name);
        this.salary = salary;
    }

    public String toString(){
        return super.toString() + ",Salary ="+salary;
    }
}
