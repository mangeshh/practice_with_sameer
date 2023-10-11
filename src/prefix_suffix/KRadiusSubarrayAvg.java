package prefix_suffix;

import java.util.Arrays;

public class KRadiusSubarrayAvg {


    // Returns the sum from index l to r (r >= l)
    static long  getSum(long[] prefSum, int l, int r) {

        long totalSum = prefSum[r]; // sum from 0 to r

        if (l > 0) {
            totalSum -= prefSum[l - 1]; // sum from 0 to l - 1
        }

        return totalSum; // sum from l to r
    }

    public static long[] prefixSum(int[] nums) {

        long[] prefSum = new long[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            prefSum[i] = nums[i] + (i > 0 ? prefSum[i - 1] : 0);
        }

        return prefSum;
    }


    public static int[] getAverages(int[] nums, int k) {

        int[] prefAvg = new int[nums.length];
        Arrays.fill(prefAvg, -1);

        long prefSum[] = prefixSum(nums);

        for (int i = k; i < (nums.length - k); i++) {

            int leftEnd = i - k;
            int rightEnd = i + k;

            long totalSum = getSum(prefSum, leftEnd, rightEnd);

            prefAvg[i] = (int) (totalSum / (2 * k + 1));
        }

        return prefAvg;
    }

    public static int[] getAveragesBrute(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int[] prefAvg = new int[nums.length];

        if (nums.length < k) {
            for (int l = 0; l < nums.length; l++) {
                prefAvg[l] = -1;
            }
            return prefAvg;
        }

        for (int l = 0; l < k; l++) {
            prefAvg[l] = -1;
        }

        for (int n = nums.length - 1; n > nums.length - (k + 1); n--) {
            prefAvg[n] = -1;
        }

        for (int i = k; i < (nums.length - k); i++) {
            long sum = nums[i];
            for (int j = 1; j <= k; j++) {
                sum += nums[i - j];
                sum += nums[i + j];
            }
            prefAvg[i] = (int) (sum / (k * 2 + 1));
        }

        return prefAvg;
    }

    public static void main(String[] args) {
        getAverages(new int[]{1, 2, 43, 2}, 2);
        //getAveragesBrute(new int[]{1, 2, 43, 2}, 2);
    }

}
