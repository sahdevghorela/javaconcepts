package java8.streams;

import java8.function.predicate.Trade;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * There are two variants of reduce operations illustrated here.
 * Both takes BinaryOperator
 */
public class ReduceOperations {

    public void testReduceWithBinaryOperator(){
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());

        Optional<Integer> sumQantity = trades
                .stream()
                .map(t -> t.getOrderQty().intValue())
                .reduce((a,b) -> a + b);

        System.out.println(sumQantity.get());
    }

    public void testReduceWithInitialValue(){
        List<Trade> trades = Arrays.asList(new Trade(), new Trade());

        int sumQty = trades
                .stream()
                .map(t -> t.getOrderQty().intValue())
                .reduce(10, (a,b) -> a+b);

        System.out.println(sumQty);
    }

}
