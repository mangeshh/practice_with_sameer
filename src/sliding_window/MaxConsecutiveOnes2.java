package sliding_window;

public class MaxConsecutiveOnes2 {
    public int findMaxConsecutiveOnes(int[] nums) {

        // 1 0 1 1 0 0 1 1 0 1 1 1 1 1
        // 1 0 1 2 0 0 1 2 0 1 2 3 4 5 -> ones_left_to_right
        // 1 0 2 1 0 0 2 1 0 5 4 3 2 1 -> ones_right_to_left

        if(nums.length == 1 ) return 1;

        int []ones_left_to_right = new int[nums.length];
        int []ones_right_to_left = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1 && i > 0){
                ones_left_to_right[i] = ones_left_to_right[i-1] + nums[i];
            }else{
                ones_left_to_right[i] = nums[i];
            }
        }

        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == 1 && i < nums.length -1){
                ones_right_to_left[i] = ones_right_to_left[i+1] + nums[i];
            }else{
                ones_right_to_left[i] = nums[i];
            }
        }

        int max = 0;
        for(int z = 0; z < nums.length ; z++) {
            if(nums[z] == 0){
                if(z == 0){
                    max = Math.max(max, ones_right_to_left[z+1] + 1);
                } else if (z == nums.length-1){
                    max = Math.max(max, ones_left_to_right[z-1] + 1);
                } else{
                    max = Math.max(max,  ones_right_to_left[z+1] + ones_left_to_right[z-1] + 1);
                }
            }
        }
        max = Math.max(max, ones_left_to_right[nums.length-1]);
        return max;

    }
}
