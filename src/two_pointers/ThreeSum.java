package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 2, i + j = -2
        Arrays.sort(nums);
        List<List<Integer>> totalCombination = new ArrayList<>();
        for(int firstNumber = 0; firstNumber + 2 < nums.length; ++firstNumber){
            int target = -nums[firstNumber];
            int secondNumber = firstNumber + 1;
            int thirdNumber = nums.length - 1;
            if(firstNumber > 0 && nums[firstNumber] == nums[firstNumber - 1]){
                continue;
            }
            while(secondNumber < thirdNumber){
                if(secondNumber > firstNumber + 1 && nums[secondNumber] == nums[secondNumber - 1]){
                    ++secondNumber;
                    continue;
                }
                // 5 -2 -2 -3 -3

                // 5 -2 -3
                // 5 -2 -3
                if(nums[secondNumber] + nums[thirdNumber] < target){
                    secondNumber++;
                }
                else if(nums[secondNumber] + nums[thirdNumber] > target){
                    thirdNumber--;
                }
                else{
                    List<Integer> combination = new ArrayList<>();
                    combination.add(nums[firstNumber]);
                    combination.add(nums[secondNumber]);
                    combination.add(nums[thirdNumber]);
                    totalCombination.add(combination);
                    ++secondNumber;
                    --thirdNumber;
                }
            }
        }
        return totalCombination;
    }
}
