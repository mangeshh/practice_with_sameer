package sliding_window;

import java.util.Stack;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        //longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2);
    }

    /**
     * What not to do!!!!
     *
     * MISTAKE !!! MISTAKE !!!
     *
     *
     * @param nums
     * @param k
     * @return
     */

    public static int longestOnes(int[] nums, int k) {

                int zeroCnt = 0;
                Stack stack = new Stack();
                int length = 0;
                int i = 1;

                if(nums[0] == 0){
                    zeroCnt++;
                }
                stack.push(nums[0]);
                // longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
                while(i < nums.length-1 && stack.size() > 0){

                    while(nums[i] == 0 && zeroCnt < k){
                        stack.push(nums[i++]);
                        zeroCnt++;
                        length = Math.max(stack.size(), length);
                    }

                    if(zeroCnt <= k){
                        stack.push(nums[i++]);
                        length = Math.max(stack.size(), length);
                    }

                    if(i < nums.length && zeroCnt >= k){
                        stack = new Stack();
                        zeroCnt = 0;
                        if(nums[i] == 0){
                            zeroCnt++;
                        }
                        stack.push(nums[i++]);

                    }

                }
                if(nums[length-1] == 1){
                    length++;
                }
                System.out.println(length);
                return length;
            }
        }

