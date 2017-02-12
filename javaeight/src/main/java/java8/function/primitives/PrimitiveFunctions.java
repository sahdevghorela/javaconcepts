package java8.function.primitives;

import java.util.Random;
import java.util.function.*;

/*
 - Primitive functions are good when you are working with primitives instead of Wrapper objects.
 - If you are using Wrappers and passing primitives instead of objects, the autoboxing process will
    create Objects in heap and thus can degrade performance of your application.
 - If you see in the methods of Primitive functions, they are specially designed to work with primitives only
 */
public class PrimitiveFunctions {

    Predicate<Integer> autoBoxingOverhead = (givenInt) -> givenInt%2==1;
    IntPredicate workWithPrimitive = (givenPrimitive) -> givenPrimitive%2==0;

    //primitive Suppliers
    IntSupplier intSupplier = () -> new Random().nextInt();
    DoubleSupplier doubleSupplier = null;
    LongSupplier longSupplier = null;

    //primitive Consumers
    IntConsumer intConsumer = System.out::println;
    DoubleConsumer doubleConsumer = d -> System.out.println(d);
    LongConsumer longConsumer = null;


    private boolean isOddNumber(int givenInt){
        autoBoxingOverhead.test(givenInt);
        return workWithPrimitive.test(givenInt);
    }

    public static void main(String[] args) {
        PrimitiveFunctions demo = new PrimitiveFunctions();
        System.out.println(demo.isOddNumber(30));

    }
}
