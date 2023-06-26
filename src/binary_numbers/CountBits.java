package binary_numbers;

import java.util.Arrays;

// LeetCode: https://leetcode.com/problems/counting-bits/

// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
// ans[i] is the number of 1's in the binary representation of i.
public class CountBits {
    public static int numberOfOnes(int n){
        int total = 0;
        while(n > 0){
            if(n % 2 == 1){
                total++;
            }
            n /= 2;
        }
        return total;
    }

    public static int[] countBits(int n) {
        // 11 -> (8 4 2 1)
        //        1 0 1 1
        //        1 0 1 1
        int [] answer = new int[n + 1];
        for(int i = 0; i <= n; ++i){
            answer[i] = numberOfOnes(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(Arrays.toString(countBits(n)));
    }
}
