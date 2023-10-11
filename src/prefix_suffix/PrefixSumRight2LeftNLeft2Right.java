package prefix_suffix;

import java.util.Arrays;

public class PrefixSumRight2LeftNLeft2Right {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 0 , 1 , 1 , 0 , 0 , 0 , 1 , 0 , 1 , 1 , 1 , 1 , 1};
        //int[] nums = new int[] {1, 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1};
        prefixSum(nums);
    }

    public static void prefixSum(int[] nums) {
        // 1 0 1 1 0 0 0 1 0 1 1 1 1 1
        // 1 0 1 2 0 0 0 1 0 1 2 3 4 5 -> ones_left_to_right


        int[] ones_left_to_right = new int[nums.length];
        int[] ones_right_to_left = new int[nums.length];

        for(int i = 0; i<nums.length;i++)
        {
            if (nums[i] == 1 && i > 0) {
                ones_left_to_right[i] = ones_left_to_right[i - 1] + nums[i];
            } else {
                ones_left_to_right[i] = nums[i];
            }
        }

        for(int i = nums.length-1; i>=0; i--)
        {
            if (nums[i] == 1 && i < nums.length-1) {
                ones_right_to_left[i] = ones_right_to_left[i + 1] + nums[i];
            } else {
                ones_right_to_left[i] = nums[i];
            }
        }

        //System.out.println(Arrays.toString(ones_left_to_right));
        System.out.println(Arrays.toString(ones_right_to_left));
    }
}
