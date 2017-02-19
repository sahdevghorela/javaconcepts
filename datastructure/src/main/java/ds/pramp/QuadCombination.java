package ds.pramp;

/*
 - Given an array of numbers arr and a number S, find 4 different numbers in arr that sum up to S.
 - Create pair and store in hashmap with pair sum as key and List of pairs as value;
 */

import java.util.*;

public class QuadCombination {

    private static int[] findArrayQuadCombination(int []array, int s){
        if(array==null || array.length < 3){
            return null;
        }

        Map<Integer, List<int[]>> hashPair = new HashMap();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                int sum = array[i]+array[j];
                if(hashPair.containsKey(s - sum)){
                    List<int []> list = hashPair.get(s-sum);
                    for(int []entry : list){
                        if(i != entry[0] && i != entry[1] && j != entry[0] && j != entry[1]){
                            return new int[]{i,j,entry[0],entry[1]};
                        }
                    }

                }else{
                    if(!hashPair.containsKey(sum)){
                        hashPair.put(sum,new ArrayList<>());
                    }
                    hashPair.get(sum).add(new int[]{i,j});
                }

            }
        }


        return null;

    }

    public static void main(String[] args) {
        int []matchInput = new int[]{1,2,1,2,3,1,1};
        int []noMathInput = new int[]{1,4,5,6,9,10};
        int []tryThis = new int[]{1,1,1,1};
        int sum = 7;
        int []output =  findArrayQuadCombination(matchInput,4);
        if(output != null){
            Arrays.stream(output)
                    .forEach(System.out::println);
        }

    }

}
