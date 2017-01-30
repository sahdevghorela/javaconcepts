package java8.lambdas;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;

public class FilesLinesDemo {

    public static void main(String[] args) {
        try {
            Files.lines(
                    new File("javaeight/src/main/resources/Mock_Dictionary.txt").toPath())
                    .filter(s -> s.length()>10)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .limit(10)
                    .forEach(s -> System.out.println(s+" = "+s.length()));


        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            Optional<String> max = Files.lines(Paths.get("javaeight/src/main/resources/Mock_Dictionary.txt"))
                    .filter(s -> s.length() > 10)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .findFirst();

            System.out.println(max.isPresent() ? max.get() : "Not found");
            System.out.println(max.orElseGet( () -> "supplying null"));
            System.out.println(max.orElse("not present"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
