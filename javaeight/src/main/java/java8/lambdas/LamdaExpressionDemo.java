package java8.lambdas;


import java8.netw.Location;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaExpressionDemo {

    private FilenameFilter javaFiles = ((dir, name) -> name.endsWith("java"));

    public void printJavaFiles(File dir){
        Arrays.stream(dir.list(javaFiles))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        File dir = new File("javaeight/src/main/java/java8/lambdas");
        new LamdaExpressionDemo().printJavaFiles(dir.getAbsoluteFile());

        Stream.of(new Location("a","a","a")).map( l -> l.getCity() )
                .collect(Collectors.joining(",") );
    }
}
