package prefix_sum;

public class KRadiusSubarrayAvg {

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
        getAveragesBrute(new int[]{1, 2, 43, 2}, 2);
    }

}
