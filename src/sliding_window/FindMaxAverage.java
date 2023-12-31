package sliding_window;

/**
 * This is fixed window problem.
 */
class FindMaxAverage {

    public static double findMaxAverage(int[] nums, int k) {

        // first iterate the window size and collect the average.
        // then increase the windows size to right and decrease from left and again find average.
        // base condition to make window, that's it.
        int right = 0;
        double sum = 0;

        // base condition.
        while(right < k){
            sum += nums[right++];
        }

        double max_avg = sum/k; // base condition.

        // now right is same as k(window size), right pointer will touch endOfWindow, so it's '< nums.length'
        while (right < nums.length){
            sum += nums[right];
            sum -= nums[right - k];
            max_avg = Math.max(max_avg, sum/k);
            right++;
        }

        return max_avg;

    }

    public static void main(String[] args) {
        //System.out.println(findMaxAverage(new int[]{1,43,2,6,8,3}, 4));
        System.out.println(findMaxAverage(new int[]{1,1,2,2,2,19}, 4));
    }
}
