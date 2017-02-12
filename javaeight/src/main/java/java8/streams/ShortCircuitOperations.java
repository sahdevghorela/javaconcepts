package java8.streams;

import java8.function.predicate.Trade;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShortCircuitOperations {

    /**
     * - Difference between findFist and findAny is that - In case of parallel processing findAny will stop
     *  processing at the very first match and doesn't process remaining items.
     *  - But in case of findFirst() all the items will be processed in parallel/sequential and then result will
     *   be returned afterwards.
     */
    public void testFindFirst(){
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());
        Optional<Trade> bigTrade = trades.stream()
                .filter(t -> t.getOrderQty().compareTo(BigDecimal.ZERO) > 1)
                .findFirst();

        System.out.println(bigTrade.get());
    }

    public void testFindAny(){
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());
        Optional<Trade> bigTrade = trades.stream()
                .filter(t -> t.getOrderQty().compareTo(BigDecimal.ZERO) > 1)
                .findAny();

        System.out.println(bigTrade.get());
    }

    public void testAnyMatch() {
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());

        boolean containsRottenTrade = trades.stream().anyMatch(t -> t.getStatus().equals("Rotten"));
        System.out.println(containsRottenTrade);
    }

    public void testAllMatch(){
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());

        boolean allIBMTrades = trades.stream().allMatch(t -> t.getInstrument().equals("IBM"));
        System.out.println(allIBMTrades);
    }

    public void testNoneMatch(){
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());

        boolean noneCancelled = trades.stream().noneMatch(t -> t.getStatus().equals("Cancelled"));
        System.out.println(noneCancelled);
    }
}
