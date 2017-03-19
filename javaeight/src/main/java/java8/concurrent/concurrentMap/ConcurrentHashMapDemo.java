package java8.concurrent.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/*
        - All ConcurrentMap methods are available in ConcurrentHashMap as well, and it has 2 more important methods (search and reduce).
		- ConcurrentHashMap perform operations in parallel with multiple threads.
		- Just like "Parallel Streams" it also uses special ForkJoinPool.commonPool() available in java8.
		- ForkJoinPool.commonPool() uses a predefined parallelism which depends on the number of cores in CPU.
		- This value can be decreased/increased by setting a JVM property: -Djava.util.concurrent.ForkJoinPool.common.parallelism=5
		- These additonal methods uses first argument as ParallelismThresold which is minimum collection size for parallelism.
		- Search() method:
			- It acccepts a BiFunction<ResultValue,Key,Value> to search.
			- It stops processing once return non null value.
			- Keep in mind that ConcurrentHashMap is unordered. So if multiple entries match the given search crieteria, result may vary from
				one invocation to other.
		- Reduce Method:
			- Just like Stream API it accepts 2 BiFunctions. First function maps the key-value pair into a single result.
				And second Function combines these transformed values into a single result.
 */
public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        ConcurrentHashMapDemo obj = new ConcurrentHashMapDemo();
        obj.search();
        obj.reduce();
    }

    public void search() {
        ConcurrentHashMap<String, String> map = getSampleMap();

        String valueLengh = map.search(1, (key, value) -> {
            System.out.println("Current Thread:" + Thread.currentThread().getName());
            return value.length() > 3 ? value : null;
        });

        System.out.println(valueLengh);
    }

    public void reduce() {
        ConcurrentHashMap<String, String> map = getSampleMap();
        String reducedValue = map.reduce(1, (key, value) -> {
                    System.out.println("Current Transformer Thread:"+Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Current Accumulator Thread:"+Thread.currentThread().getName());
                    return s1 + "," + s2;
                });
        System.out.println("Reduced Map is "+reducedValue);
    }

    private static ConcurrentHashMap<String, String> getSampleMap() {
        ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("foo", "foo");
        concurrentMap.put("bar", "bar");
        concurrentMap.put("loream", "loream");
        concurrentMap.put("ipsum", "ipsum");
        return concurrentMap;
    }
}
