package java8.streams.flatMap;

import java8.function.consumer.ConsumerDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 - Its used to flatten the object graph. Its used to combine two or more streams into one.
 */
public class StreamFlatMapDemo {

    List<ConsumerDemo.Movie> movies = Arrays.asList(new ConsumerDemo.Movie("Ben Hur"));
    String []fruits = {"Apple","Banana"};
    String []vegitables = {"Patato","Tomato"};


    public void flatMapDemo(){
        Stream<String> actorsStream = movies
                .stream()
                .flatMap(m -> m.getActors().stream());

        actorsStream.forEach(System.out::println);
    }

    public void flatMapDemo2(){
        Stream<String> flattenedStream = Stream.of(Arrays.asList(fruits),Arrays.asList(vegitables)).flatMap(List::stream)
;
        flattenedStream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamFlatMapDemo flatMapDemo = new StreamFlatMapDemo();
        flatMapDemo.flatMapDemo2();
    }
}
