package dynamic_programming;

import java.util.Arrays;

/**
 * refer LongestIncreasingSubsequence first then do KadaneMaxSubarray
 */
public class SubarrayMaxByKadane {

    // Max likalo (abhi tak ka total or current number)
    public static int kadaneSpaceOptimized(int []nums){
        int n = nums.length;

        int currentMaxSumEnding = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < n; ++i){
            // dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // currentMaxSumEnding is same as dp[i-1]
            currentMaxSumEnding = Math.max(currentMaxSumEnding + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMaxSumEnding);
        }

        return maxSum;
    }

    public static int kadane(int []nums){
        int n = nums.length;

        int []dp = new int[n];

        dp[0] = nums[0];

        for(int i = 1; i < n; ++i){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        System.out.println("Nums Arr: " + Arrays.toString(nums));
        System.out.println("DP Array: " + Arrays.toString(dp));

        int maxSum = Arrays.stream(dp).max().getAsInt();
        return maxSum;
    }

    public static void main(String[] args) {
//        4, -3, -2, 2, 3, 1, 4, 2, -6 --> nums[i]
//
//        Definition - Let dp[i] be the maximum sum that we can get while "including" the ith index (we have to include) in the subarray
//
//        There are two possibilities to include index i:
//          1.  nums[i] extends the previous subarray (i - 1 ki hi baat ho rahi hai)           { dp[i] = dp[i - 1] + nums[i] }
//          2.  nums[i] does not extend the previous subarray                                  { dp[i] = nums[i] }

//        In the end, I will print max element of dp array.

//        Here dp[n - 1] doesn't necessarily is the answer because our definition of dp[i] says including index i and not till index i

        System.out.println(kadane(new int[]{4, -3, -2, 2, 3, 1, 4, 2, -6}));
        System.out.println(kadaneSpaceOptimized(new int[]{4, -3, -2, 2, 3, 1, 4, 2, -6}));
    }
}
