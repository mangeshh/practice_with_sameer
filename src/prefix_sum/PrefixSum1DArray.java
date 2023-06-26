package prefix_sum;

import java.util.Arrays;

//  LeetCode: https://leetcode.com/problems/running-sum-of-1d-array/

//  Given an array nums. We define a running sum of an array as:
//  runningSum[i] = sum(nums[0]…nums[i]).
public class PrefixSum1DArray {
    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 6};

        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        return nums;
    }
}
