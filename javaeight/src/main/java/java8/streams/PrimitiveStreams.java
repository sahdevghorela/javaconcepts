package java8.streams;


import java8.function.predicate.Trade;
import java8.function.primitives.PrimitiveFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PrimitiveStreams {

    private void costOfAutoBoxingWithRegularStreams(){
        List<Trade> trades = Arrays.asList(new Trade(),new Trade());

        /*
         - In this operation the cost of convering ints to Integers is included
         */
        Optional<Integer> quantitySum = trades.stream()
                .map(t -> t.getOrderQty().intValue())
                .reduce(Integer::sum);
    }

    private void workingWithPrimitiveStreamsToAvoidBoxingEffort(){
        List<Trade> trades = Arrays.asList(new Trade(),new Trade());

        int quantitySum =  trades.stream()
                .mapToInt( trade -> trade.getOrderQty().intValue())
                .sum();
        System.out.println(quantitySum);
    }

    public static void main(String[] args) {
        PrimitiveStreams ps = new PrimitiveStreams();
        ps.costOfAutoBoxingWithRegularStreams();
        ps.workingWithPrimitiveStreamsToAvoidBoxingEffort();
    }

}
