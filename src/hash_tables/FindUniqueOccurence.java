package hash_tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindUniqueOccurence {
//    Given an array of integers arr, return true if the number of occurrences of each value in
//    the array is unique or false otherwise

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap();
        Set<Integer> set = new HashSet();

        for(int number : arr){
            if(map.containsKey(number)){
                map.put(number, map.get(number) + 1);
            } else{
                map.put(number, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            boolean result = set.add(entry.getValue());
            if(!result){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {3, 3, 4, 5, 6, 7, 7, 8};
        System.out.println(uniqueOccurrences(nums));
    }
}
