package sliding_window;

import java.util.Arrays;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        findMaxConsecutiveOnes(new int[]{1,0,0,1,1,1,0});
    }
    public static int findMaxConsecutiveOnes(int[] nums) {


            // 2 pointers, because of dynamic window (subarray)
            // right and left - points to zero then increase right till zero and at zero
            // change the right to zero + 1 and left also same.
            // max_length = Math.max(max_length, (right-1left));

            int left = 0;
            int right = 0;
            int length = 0;

            while (right < nums.length) {
                if (nums[right] > 0) {
                    right++;
                    if (right == nums.length - 1) {
                        length = Math.max(length, (right - left + 1));
                    }
                } else {
                    length = Math.max(length, (right - left));
                    right++;
                    left = right;
                }

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