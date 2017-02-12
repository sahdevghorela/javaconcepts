package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class GenerateStreams {

    private void generateByOf(){
        Stream<String> stringStream = Stream.of("First","Second");
        stringStream.forEach(System.out::println);
    }

    private void generateFromList(){
        List<String> strings = Arrays.asList("First","Second");
        Stream<String> stream = strings.stream();
        stream.forEach(System.out::println);
    }

    private void generateUsingGenerate(){
        Stream<Double> stream = Stream.generate(Math::random)
                .limit(10);
        stream.forEach(System.out::println);
    }

    private void generateByIterate(){
        Stream<Integer> stream = Stream.iterate(1, i -> i+1);
        stream.limit(10).forEach(System.out::println);
    }

    public static void main(String[] args) {
        GenerateStreams generateStreams = new GenerateStreams();
        generateStreams.generateByIterate();
        generateStreams.generateByOf();
        generateStreams.generateFromList();
        generateStreams.generateUsingGenerate();
    }
}
