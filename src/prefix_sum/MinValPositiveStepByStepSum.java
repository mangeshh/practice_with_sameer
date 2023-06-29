package prefix_sum;

/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/description/
 */
public class MinValPositiveStepByStepSum {

    public static int minStartValue(int[] nums) {
        int [] prefix = new int[nums.length];
        prefix[0] = nums[0];
        int minValue = nums[0];

        for(int i = 1 ; i < nums.length; i++){
            prefix[i] = prefix[i-1] + nums[i];
            minValue = Math.min(minValue, prefix[i]);
        }

        if(minValue > 0){
            return 1;
        } else{
            return Math.abs(minValue) + 1;
        }

    }

    public static void main(String[] args) {
        minStartValue(new int[]{-3,2,-3,4,2});
    }
}
