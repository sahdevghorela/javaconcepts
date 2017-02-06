package java8.concurrent;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SummaryStatisticsDemo {

    public static void main(String args[]) {
        DoubleSummaryStatistics doubleSummaryStatistics = Stream.generate(Math::random)
                .limit(100)
                .collect(Collectors.summarizingDouble(Double::valueOf));
        System.out.println(doubleSummaryStatistics);

        IntSummaryStatistics intSummaryStatistics = Stream.of("abcd", "xyxxxxx", "something", "stream")
                .mapToInt(String::length)
                .summaryStatistics();
        System.out.println(intSummaryStatistics);

    }
}
