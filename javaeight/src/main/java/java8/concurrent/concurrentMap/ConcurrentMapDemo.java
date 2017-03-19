package java8.concurrent.concurrentMap;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
        - ConcurrentMap extends the Map interface and defines one of the most usefull concurrent collection types.
		- Java8 added functional style methods in this interface.
		- Below are some of the key functions of Concurrent Map.
		- 1. forEach(BiConsumer<Key,Value>).putIfAbsent(key,value), getOrDefault(key,defaultValue)
		- 2. replaceAll(BiFunction<NewValue,Key,Value>) gives every entry in the map to the function to be accepted for replacement.
		- 3. compute("key",BiFunction<NewValue,Key,Value>) allows the perticular entry with given key to be replaced with new value.
		- 4. merge(key, newValue,Function<oldValue,NewValue>) can be used to merge newValue for the key with oldValue.
 */
public class ConcurrentMapDemo {

    private static ConcurrentMap<String,String> getSampleMap(){
        ConcurrentMap<String,String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("foo","foo");
        concurrentMap.put("bar","bar");
        concurrentMap.put("loream","loream");
        concurrentMap.put("ipsum","ipsum");
        return concurrentMap;
    }

    public static void main(String[] args) {
        ConcurrentMapDemo demo = new ConcurrentMapDemo();
        demo.forEach();
        demo.putIfAbsent();
        demo.getOrDefault();
        demo.replaceAll();
        demo.compute();
        demo.merge();
    }

    public void forEach(){
        getSampleMap()
                .forEach((key,value) -> System.out.println("Key="+key+",Value="+value));
    }

    public void putIfAbsent(){
        getSampleMap()
                .putIfAbsent("foo","bar");
    }

    public void getOrDefault(){
        String value = getSampleMap()
                .getOrDefault("key","defaultValue");
        System.out.println(value);
    }

    public void replaceAll(){
        getSampleMap()
                .replaceAll(
                        (key,value) -> {
                            if("foo".equals(key)){
                                return "newFoo";
                            }else{
                                return value;
                            }
                        }
                );
    }

    public void compute(){
       String newValue =  getSampleMap()
                .compute("bar",(key,value) -> {
                    return value+value;
                });

        System.out.println(newValue);
    }

    public void merge(){
       String newMergedValue =  getSampleMap()
                .merge("loream","newLoream",(oldValue,newValue) -> {
                    return newValue + " was " + oldValue;
                });

        System.out.println(newMergedValue);
    }

}
