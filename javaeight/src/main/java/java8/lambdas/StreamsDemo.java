package java8.lambdas;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

    private List<String> strings = Arrays.asList("this","is","a","list","of","stringgs");

    public String joinStream(){
        return strings.stream()
                .collect(Collectors.joining(" "));
    }

    /*
    -By calling map method, We are producing new elements instead of modifying existing ones
    - This is one of the characteristics of Functional programming
     */
    public String joinUpperCase(){
        return strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" "));
    }

    public int getTotalLength(){
        //strings.stream().mapToInt(String::length).sum();
        return strings.stream()
                .collect(Collectors.summingInt(String::length));

    }

    public double sumFirstNBigDecimals(int num){
        return Stream.iterate(BigDecimal.ONE, val -> val.add(BigDecimal.ONE))
                .limit(num)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
    }

    public double sumRandom1(int num){
        return Stream.generate(Math::random)
                .limit(num)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public int sumRandom2(int num){
        return Stream.generate( () ->  new Random().nextInt(5))
                .limit(num)
                .reduce((acc,n) -> {
                    System.out.println("acc="+acc+" n="+n);
                    return acc+n;
                })
                .orElse(0);
    }

    public double sumRandom3(int num){
        Random random = new Random();
        return random.doubles()
                .limit(num)
                .sum();
    }

    public static void main(String args[]){
        StreamsDemo streamsDemo = new StreamsDemo();
        System.out.println(streamsDemo.sumRandom2(1));
    }

}


