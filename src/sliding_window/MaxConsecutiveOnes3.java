package sliding_window;

import java.util.Stack;

public class MaxConsecutiveOnes3 {

    public static void main(String[] args) {
        longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3);
        //longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }


    public static int longestOnes(int[] nums, int k) {


        int n = nums.length;

        int left = 0;

//        Right ko ek ek kar ke fixed krna hai
        int right = 0;
        int current_zero_count = 0;

        int maxLen = Integer.MIN_VALUE;

        while (right < n) {
            if (nums[right] == 0) {
                current_zero_count += 1;
            }

//            Main left ko aage tabhi bahaunga jab current window ka sum 10 ya usse bada hai
            while (current_zero_count > k) {
                if (nums[left] == 0) {
                    current_zero_count -= 1;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return  maxLen;

    }


}

