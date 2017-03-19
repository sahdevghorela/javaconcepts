package java8.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * By using AtomicInteger as a replacement of Integer,
 * we are able to increment the number concurrently in a thread safe manner without
 * synchronizing the access to the variable.
 */
public class AtomicIntegerDemo {

    private int count = 0;

    private void increment(){
        count = count+1;
    }

    public static void nonAtomicIntegerIssueDemo(){

        AtomicIntegerDemo obj = new AtomicIntegerDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(400);

        IntStream.range(0,1000)
                .forEach( i -> executorService.submit( () -> obj.increment()));

        stop(executorService);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Non Atomic operation count is " + obj.count);

    }


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(400);
        Runnable task = () -> atomicInteger.incrementAndGet();

        IntStream.range(0,1000)
                .forEach( i -> executorService.submit(task));

        stop(executorService);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Atomic operation count is " + atomicInteger.get());

        nonAtomicIntegerIssueDemo();


    }

    private static void stop(ExecutorService executorService) {
        executorService.shutdown();
    }
}
