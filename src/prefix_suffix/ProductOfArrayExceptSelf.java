package prefix_suffix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * 238. Product of Array Except Self
 *
 */
public class ProductOfArrayExceptSelf {

    /**
     *       [1,2,3,4]
     *
     *       1    2   6   24
     *       24   24  12  4
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int [] prefix  = new int[nums.length];
        int [] suffix   = new int[nums.length];
        int [] products = new int[nums.length];


        prefix[0] = nums[0];
        suffix[nums.length-1] = nums[nums.length-1];

        for(int j= 1; j < nums.length; j++){
            prefix[j] = nums[j] * prefix[j-1];
        }
        for(int k= nums.length-2; k >= 0; k--){
            suffix[k] = nums[k] * suffix[k+1];
        }
        for(int l= 0; l < nums.length; l++){
            if(l==0){
                products[l] = suffix[l+1];
            }
            else if(l==nums.length-1){
                products[l] = prefix[l-1];
            }else {
                products[l] = prefix[l-1] * suffix[l+1];
            }

        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(suffix));
        System.out.println(Arrays.toString(products));
        return products;
    }

    public static void main(String[] args) {
        productExceptSelf(new int [] {1,2,4,3});
    }
}
