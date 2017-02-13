package java8.streams.ranges;


import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class RangeDemo {

    public void rangeDemo(){
        IntStream intStream = IntStream.range(10,20);
        IntStream intStreamRangeClosed = IntStream.rangeClosed(10,20);

        OptionalInt max = intStream.max();
        System.out.println("Max is "+max);

        //Throws exceptio at run time, Stream is already closed
        OptionalInt min = intStream.min();
        System.out.println("Min is "+min);

        intStream = IntStream.range(10,20);
        min = intStream.min();
        System.out.println("Min is "+min);

        intStream = IntStream.range(10,20);
        OptionalDouble average = intStream.average();
        System.out.println("average is "+average);
    }
}
