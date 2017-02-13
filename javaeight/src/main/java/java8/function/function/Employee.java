package java8.function.function;


public class Employee {

    private String dept;
    private String city;
    private boolean executive;
    private boolean senior;

    public Manager getManager(){
        return new Manager();
    }

    public String getDepartment(){
        return dept;
    }

    public String getCity(){
        return this.city;
    }

    public boolean isExecutive(){
        return executive;
    }

    public boolean isSenior() {
        return this.senior;
    }
}
