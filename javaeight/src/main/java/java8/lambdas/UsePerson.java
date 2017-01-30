package java8.lambdas;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsePerson {

    private List<String> names = Arrays.asList("Name1","Name2","Name3");

    public List<Person> createPersonList(){
        return names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());
    }

    public Person[] createPersonArray(){
        return names.stream()
                .map(Person::new)
                .toArray(Person[]::new);
    }

    public List<Person> createPersonListUsingNew(){
        return names.stream()
                .map(Person::new)
                .collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
    }

    private static class Person{

        private Integer id;
        private String name;

        public Person(String name){
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
