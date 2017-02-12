package java8.function.predicate;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ComposingPredicateDemo {

    Predicate<Trade> bigTrade = trade -> trade.getOrderQty().intValue()> 10_000;
    Predicate<Trade> cancelledTrade = trade -> trade.getStatus().equals("CANCELLED");

    Predicate<Trade> bigAndCancelledTrade = bigTrade.and(cancelledTrade);

    Predicate<Trade> notCancelledTrade = cancelledTrade.negate();

    public void testIsEquaals(){
        List<Trade> trades = Arrays.asList(new Trade(),new Trade());

        Trade trade = new Trade("GOOG",BigDecimal.ONE,"NEW");
        Predicate<Trade> matchingTrade = Predicate.isEqual(trade);

        trades.stream()
                .filter(matchingTrade)
                .findFirst()
                .ifPresent(System.out::println);

    }

}
