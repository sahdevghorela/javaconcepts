package java8.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDemo {

    private List<String> sampleStrings = Arrays.asList("this","is","a","string","to","be","compared");

    //Default sort from java 7
    public List<String> defaultSort(){
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    //java 7 using Comparator
    public List<String> lengthReverseSortWithComparator(){
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return sampleStrings;
    }

    //Using lambda as a comparator
    public List<String> lengthSortWithLambda(){
        Collections.sort(sampleStrings, (s1,s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    //lenght sort verbose
    public List<String> lengthSortVerbose(){
        Collections.sort(sampleStrings,
                (String s1,String s2) ->
                { return Integer.compare(s1.length(),s2.length());
                }
        );

        return sampleStrings;
    }

    //length sort with comparingInt
    public List<String> lengthSortComparator(){
        Collections.sort(sampleStrings,Comparator.comparingInt(String::length));
        return sampleStrings;
    }

    //length sort and then Alphabatical sort
    public List<String> lengthSortAndThenAlphaSort(){
        Collections.sort(sampleStrings,
                Comparator.comparingInt(String::length)
                    .thenComparing(Comparator.naturalOrder())
        );
        return sampleStrings;
    }

    //alphabatica sort using Stream sorted()
    public List<String> alphaSortUsingStreamSorted(){
        return sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    //Sort by length with Stream sorted
    public List<String> lengthSortWithStreamSorted(){
        return sampleStrings.stream()
                .sorted((s1,s2) -> s1.length()-s2.length())
                .collect(Collectors.toList());
    }

    //Sort by Length and then sort by alpha using Stream Sort
    public List<String> lengthSortAndThenAlphaSortUsingStreamSort(){
        return sampleStrings.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

}