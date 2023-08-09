package dynamic_programming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        // dp[i], min cost to reach the ith index.
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }
}

