package java8.concurrent;


import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LazyStreamDemo {

    private static int multiplyByTwo(int d){
        System.out.println("Inside multiply by 2 for "+d);
        return d*2;
    }

    public static void main(String[] args) {
        //Find first double divisible by 3 between 200 and 400
        int firstDoubleDivisibleBy3 = IntStream.range(100,200)
                .map(LazyStreamDemo::multiplyByTwo)
                .filter(n -> n%3 == 0)
                .findFirst()
                .orElse(999);

        System.out.println("firstDoubleDivisibleBy3 is "+firstDoubleDivisibleBy3);
    }
}
