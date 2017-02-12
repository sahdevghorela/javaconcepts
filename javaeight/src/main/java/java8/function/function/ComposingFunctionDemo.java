package java8.function.function;


import java.util.function.Function;

public class ComposingFunctionDemo {

    Function<Employee,Manager> managerFinder = Employee::getManager;
    Function<Manager,Employee> personalAssistantFinder = Manager::getPersonalAssistant;

    public void composeFunctionsDemo(Employee employee){
        Function<Employee,Employee> empToPA = managerFinder.andThen(personalAssistantFinder);
        Function<Employee,Employee> empToPA2 = personalAssistantFinder.compose(managerFinder);

        Employee personalAssistant = empToPA.apply(employee);
        System.out.println(personalAssistant);
    }

    public void identityFunctionDemo(){
        Function<String,String> identity = Function.identity();
        String out = identity.apply("ABCD");
        System.out.println("Output is "+out);
    }

    public static void main(String[] args) {
        ComposingFunctionDemo composingFunctionDemo = new ComposingFunctionDemo();
        composingFunctionDemo.composeFunctionsDemo(new Employee());
        composingFunctionDemo.identityFunctionDemo();
    }


}
