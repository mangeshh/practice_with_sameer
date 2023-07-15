package dynamic_programming;

import java.util.Arrays;

public class HouseRobber {
    public static void main1(String[] args) {
//        0 1 2
//        nums: [3 5 1 7 4]
//        3 1 4 = 8
//        5 7   = 12
//        5 4   = 9

//        points[n]

//        points[i] will tell me the maximum money that the robber will get TILL index i if he robs optimally

//        points[0] = 3 ( nums[0] )
//        points[1] = 5 ( max(nums[0], nums[1] )
//        points[2] = 5
//          I have two choices at 2nd index:
//
//              a. I will rob the house with index 2
//                  then    points[2] = nums[2] + points[0]
//
//              b. I will not rob the house with index 2
//                  then    points[2] = points[1]


//        At the ith index,
//              a. I will rob the ith index:
//                  then    points[i] = nums[i] + points[i - 2]
//              b. I will not rob the ith house:
//                  then    points[i] = points[i - 1]


        int nums[] = new int[]{3, 5, 1, 7, 4};

        int n = nums.length;

        int points[] = new int[n];

        points[0] = nums[0];
        points[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; ++i){
            points[i] = Math.max(nums[i] + points[i - 2], points[i - 1]);
        }

        System.out.println("Maximum money " + points[n - 1]);
        System.out.println(Arrays.toString(points));

    }

//    prices = [6, 9, 1, 5, 7]
}

