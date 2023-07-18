package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and a target sum.
 * You have to find out weather there exists a subset with that sum.
 */


public class SubsetSum {
    public static List<List<Integer>> findSubsetsWithSum(int[] nums, int target){
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(0, 0, new ArrayList<>(), subsets, target, nums);
        return subsets;
    }

//    This will generate all subsets with elements starting from currentIndex and summing up to target - previousSum
    public static void backtrack(int currentIndex, int previousSum, ArrayList<Integer> previousSubset, List<List<Integer>> subsets, int target, int []nums){

        if(previousSum == target){
            subsets.add(new ArrayList<>(previousSubset));
            return;
        }

        if(currentIndex == nums.length || previousSum > target){
            return;
        }


        previousSubset.add(nums[currentIndex]);
        previousSum += nums[currentIndex];

        backtrack(currentIndex + 1, previousSum, previousSubset, subsets, target, nums);

        previousSubset.remove(previousSubset.size() - 1);
        previousSum -= nums[currentIndex];

        backtrack(currentIndex + 1, previousSum, previousSubset, subsets, target, nums);



    }

    public static void main(String[] args) {
        int []nums = new int[] {10, 5, 4, 9};
        int target = 14;

        List<List<Integer>> subsets = findSubsetsWithSum(nums, target);
        System.out.println(subsets);
    }
}
