package java8.concurrent;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaEffectivelyFinalVariableDemo {

    public static void main(String[] args) {
        int x =2;
        Stream.of(1,3,5,4,8,9)
                .mapToInt( n -> {
                    //x++;
                    /*
                    -We can use a variable defined outside the scope of lambda but can't change it.
                    - So above commented line will not compile if uncommented.
                     */
                    return n*x;
                })
                .forEach(System.out::println);

        //Side effect of lambda scoping
        List<String> strings = Arrays.asList("this","is","a","string","to","b","used");
        List<String> evenLengths = new ArrayList<>();
        strings.stream()
                .filter(s -> s.length()%2==0)
                .forEach(evenLengths::add);
        System.out.println(evenLengths);

        //No side effects
        evenLengths = strings.stream()
                .filter(s -> s.length()%2==0)
                .collect(Collectors.toList());
        System.out.println(evenLengths);

    }
}
