package java8.defaultMethods;

public class CompanyEmployee implements Company,Employee{

    /*
    -We can not have multiple implementations of interfaces with same default methods.
    - As an alternative we can override default method and reuse super methods.
     */
    @Override
    public String getName() {
        return Company.super.getName() + Employee.super.getName();

    }
}

interface Company{

    default String getName(){
        return "Company Name";
    }
}

interface  Employee{
    default String getName(){
        return "";
    }
}
