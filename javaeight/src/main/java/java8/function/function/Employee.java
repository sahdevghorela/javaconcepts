package java8.function.function;


public class Employee {

    private String dept;
    private String city;

    public Manager getManager(){
        return new Manager();
    }

    public String getDepartment(){
        return dept;
    }

    public String getCity(){
        return this.city;
    }
}
