package dynamic_programming;

public class ClimbingStairs {

    public static void main(String[] args) {
//        n = 3
//        Initially I am at zeroth stairs

//        1 + 1 + 1
//        1 + 2
//        2 + 1
//        3 (not valid because it is 3 units jump which is not allowed)

//        If n = 100
//        I won't think of 100 first, I will think for 1, 2, 3, and so on.

//        dp[i] is the number of ways to reach at the ith stair

//        dp[0] = 0
//        dp[1] = 1
//        dp[2] = 2     {1 + 1, 2}
//        dp[3] = 3

//        For dp[4] my last step is 4th stair only. But what can be my 2nd last stairs?
//                                                  2nd and 3rd
//
//        Two choices for my second last stair
//                  a. 3rd Stair is my second last stair:
//                      Then I can only jump 1 stair
//                      [3, 4]
//                      Then there are dp[3] ways to reach 4th stair if 3rd stair is my second last

        //          b. 2nd Stair is my second last stair:
//                      Then I can only jump 2 stair
//                      [2, 4]
//                      Then there are dp[2] ways to reach 4th stair if 2nd stair is my second last

//                   dp[4] = dp[3] + dp[2]

        int n = 5;

        int []dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println("The number of ways to reach " + n + " steps is " + dp[n]);



    }
}
