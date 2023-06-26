package two_pointers;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
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
}
