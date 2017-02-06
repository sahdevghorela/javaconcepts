package java8.concurrent;


import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ParallelStreamDemo {

    private List<Integer> nums = Arrays.asList(3,1,4,1,5,9,2,6,5,4,5,6,9,0,4,3,6);

    private Function<Integer,Integer> doubler = n -> n * 2;

    private UnaryOperator<Integer> doublerWithSleep = n -> {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        return n*2;
    };

    private void printNums(Function<Integer,Integer> function){
        nums.stream()
                .map(function)
                .forEach(System.out::println);
    }

    private void printNumsParallel(Function<Integer,Integer> function){
        nums.parallelStream()
        .map(function)
        .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ParallelStreamDemo demo = new ParallelStreamDemo();
        long currentTime = System.nanoTime();
        demo.printNums(demo.doubler);
        long endTime = System.nanoTime();
        System.out.println("Total="+(endTime-currentTime)/1e9);

        currentTime = System.nanoTime();
        demo.printNums(demo.doublerWithSleep);
        endTime = System.nanoTime();
        System.out.println("Total="+(endTime-currentTime)/1e9);

        currentTime = System.nanoTime();
        demo.printNumsParallel(demo.doublerWithSleep);
        endTime = System.nanoTime();
        System.out.println("Total Parallel="+(endTime-currentTime)/1e9);

    }
}
