package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// TODO - yet not completed
public class TwoSum {

    public static List<int[]> allTwoSum(int[] nums, int target) {
        List<int[]> list = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap <>();

        for(int i = 0; i < nums.length; ++i){
            int firstNumber = nums[i];
            int secondNumber = target - nums[i];

            if(freq.containsKey(secondNumber)){
                list.add(new int[]{i, freq.get(secondNumber)});
            }

            freq.put(firstNumber, freq.getOrDefault(firstNumber, 0) + 1);
        }

        return list;
    }

    public static int[] twoSum(int[] nums, int target) {
        // [key, value]
        // nums[index] = value;

        // [2 -> 0]
        // [7 -> 1]
        // [11 -> 2]

        // ArrayList, HashSet, HashMap

        HashMap<Integer, Integer> map = new HashMap <>();

        for(int i = 0; i < nums.length; ++i){
            int firstNumber = nums[i];
            int secondNumber = target - nums[i];

            if(map.containsKey(secondNumber)){
                return new int[]{i, map.get(secondNumber)};
            }

            map.put(firstNumber, i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        // int [] answer = twoSum(new int[]{1,2,8,10,4,6,6,6}, 12);
        //System.out.println(Arrays.toString(answer));
        List<int []> answerList = allTwoSum(new int[]{1,2,8,10,4,6,6,6}, 12);
        for(int [] i : answerList){
            System.out.println(Arrays.toString(i));
        }
    }
}
