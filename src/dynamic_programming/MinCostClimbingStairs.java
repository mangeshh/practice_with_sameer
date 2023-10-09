package dynamic_programming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 *
 *
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6; Now see the explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 */
public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {

        System.out.println("input length is " + cost.length);

        // dp[i], min cost to reach the ith index.
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);

        // we have to use accumulated cost meaning dp plus cost.
        // consider dp and cost separate array.
        for (int i = 2; i <= n; i++) {
            System.out.println("calculating `dp["+i+"]` we are comparing Math.min(dp["+(i - 2)+"]+cost["+ (i - 2) + "], dp["+ (i-1) + "]+cost["+ (i-1) +"])" );
            System.out.println("dp["+(i-2)+"]=" + dp[i-2] + " and dp["+(i-1)+"]=" + dp[i-1] + " && cost["+(i-2)+"]=" + cost[i-2] + " and cost["+(i-1)+"]=" + cost[i-1]);
            System.out.println("ANSWER - To get `dp["+i+"]` we are comparing Math.min("+ (dp[i-2] + cost[i-2]) + ", " + (dp[i-1] + cost[i-1] + ")"));

            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
            System.out.println("so dp["+i+"]="+ dp[i]);
            System.out.println();
        }

        System.out.println("length of dp is " + dp.length + " and values are " + Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        minCostClimbingStairs(new int [] {1,100,1,1,1,100,1,1,100,1});
    }
}

