package java8.streams.collector;


import java8.function.predicate.Trade;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CustomCollectorDemo {

    List<Trade> trades = Arrays.asList(new Trade(), new Trade());

    private void collectToCustomCollector() {

        Supplier<StringBuilder> supplier = StringBuilder::new;
        BiConsumer<StringBuilder, Trade> accumulator = (sb, trade) -> sb.append(trade.getInstrument()).append(",");
        BiConsumer<StringBuilder, StringBuilder> combiner = (sb1, sb2) -> sb1.append(sb2.toString());

        StringBuilder commaSeparatedSymbols = trades.stream()
                .collect(supplier, accumulator, combiner);
        System.out.println(commaSeparatedSymbols);
    }

    private void summaryStatsDemo() {
        IntSummaryStatistics intSummaryStatistics = trades
                .stream()
                .collect(Collectors.summarizingInt(t -> t.getOrderQty().intValue()));

        System.out.println(intSummaryStatistics);
    }
}
