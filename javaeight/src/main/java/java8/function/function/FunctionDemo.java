package java8.function.function;


import java8.function.consumer.ConsumerDemo;
import java8.function.predicate.Trade;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.math.BigDecimal.ZERO;

public class FunctionDemo {

    Function<String,ConsumerDemo.Movie> movieFinder = (movieName) -> new ConsumerDemo.Movie(movieName);

    Supplier<List<Trade>> tradesSupplier = () -> Arrays.asList(new Trade("IBM", ZERO,"NEW"),new Trade());

    Function<String,Trade> tradeFinder = (symbol) -> {
        return tradesSupplier.get()
                .stream()
                .filter( trade -> symbol.equals(trade.getInstrument()))
                .findFirst()
                .orElse(new Trade());
    };

    public static void main(String[] args) {
        FunctionDemo functionDemo = new FunctionDemo();
        ConsumerDemo.Movie movie = functionDemo.movieFinder.apply("God must be crazy");
        System.out.println(movie);

        Trade trade = functionDemo.tradeFinder.apply("IBM");
        System.out.println(trade);
    }
}
