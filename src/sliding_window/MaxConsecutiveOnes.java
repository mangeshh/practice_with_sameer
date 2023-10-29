package sliding_window;

import java.util.Arrays;

/**
 * this is dynamic window problem.
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        findMaxConsecutiveOnes(new int[]{1, 0, 0, 1, 1, 1, 0});
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int right = 0;
        int length = 0;
        int consecutive = 0;

        while (right < nums.length) {
            if (nums[right] > 0) {
                consecutive++;
                length = Math.max(length, consecutive);
            } else {
                consecutive = 0;
            }
            right++;
        }

        return length;

    }

    /**
     * 2nd method.
     *
     * public int findMaxConsecutiveOnes(int[] nums) {
     *
     *       Stack<Integer> stack = new Stack<Integer>();
     *       int length = 0;
     *       for (int i = 0; i < nums.length; i++){
     *           if(nums[i]> 0){
     *               stack.push(nums[i]);
     *               length = Math.max(length, stack.size());
     *           }else{
     *             stack = new Stack<Integer>();
     *           }
     *       }
     *
     *       return length;
     *     }
     */

}