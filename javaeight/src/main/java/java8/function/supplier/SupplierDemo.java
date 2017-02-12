package java8.function.supplier;


import java8.function.predicate.Trade;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    private Supplier<String[]> fruitsSupplier = () -> new String[]{"Apple","Orange"};
    private Supplier<List<Trade>> tradesSupplier = () -> Arrays.asList(new Trade(),new Trade());

    public static void main(String[] args) {

        SupplierDemo supplierDemo = new SupplierDemo();
        String []fruites = supplierDemo.fruitsSupplier.get();
        for(String fruit : fruites){
            System.out.println("Fruit is "+fruit);
        }

        supplierDemo
                .tradesSupplier
                .get()
                .forEach((trade) -> System.out.println(trade));

    }
}
