package dynamic_programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
//    3, 5, 2, 8, 4, 1

//    hello -> eo

//    Few valid increasing subsequence are:
//          3, 5
//          3
//          5, 8

//    Step: 1
//    Base Cases:
//    dp[0] = 1
//    dp[1] = 2
//    dp[2] = 1

//    dp[i] is the longest increasing subsequence till index i [and including it]

//    dp[3] =
//          Choices:
//              If nums[0] < nums[3]
//              a. 0th index is the second last element (dp[3] = dp[0] + 1 = 2)     [3, 8]

    //          If nums[1] < nums[3]
//              b. 1st index is the second last element (dp[3] = dp[1] + 1 = 3)      [3, 5, 8]

//              If nums[2] < nums[3]
//              c. 2nd index is the seconf last element (dp[3] = dp[2] + 1 = 2)       [2, 8]


    public static void main(String[] args) {
//      4 9 6
        int []nums = new int[]{3, 5, 2, 8, 4, 6};

        int n = nums.length;
        int []dp = new int[n];

        dp[0] = 1;

        dp[1] = (nums[1] > nums[0] ? 2 : 1);

        for(int largestIndex = 2; largestIndex < n; ++largestIndex){

            for(int secondLargestIndex = 0; secondLargestIndex < largestIndex; ++secondLargestIndex){
                if(nums[secondLargestIndex] < nums[largestIndex]){
                    dp[largestIndex] = Math.max(dp[largestIndex], dp[secondLargestIndex] + 1);
                }
            }
        }


        Arrays.sort(dp);
        System.out.println("The longest increasing subsequence in this array " + dp[n - 1]);


    }

}
