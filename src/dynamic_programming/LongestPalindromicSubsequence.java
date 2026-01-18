package dynamic_programming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    /*
        Sample Input:
            s = "bbbab"

        Few valid palindromic subsequences:
            b
            bb
            bbb
            bab
            bbbab

        "definition(super imp)" - dp[i][j] is the longest palindromic subsequence in substring s[i..j]

        Base Cases:
            dp[i][i] = 1   // every single character is a palindrome

        dp[0][1] = (s[0] == s[1]) ? 2 : 1
        dp[1][2] = (s[1] == s[2]) ? 2 : 1

        dp[0][2] = Choices:
            If s[0] == s[2]:
                a. Take both ends → dp[0][2] = 2 + dp[1][1] = 3
            Else:
                b. Skip one end → max(dp[1][2], dp[0][1])

        dp[0][4] = Choices:
            s[0] == s[4] → yes
                → dp[0][4] = 2 + dp[1][3]
    */

    public static void main(String[] args) {

        String inputString = "bbbab";
        int stringLength = inputString.length();

        int[][] dp = new int[stringLength][stringLength];

        // Base case: every single character is a palindrome of length 1
        for (int i = 0; i < stringLength; i++) {
            dp[i][i] = 1;
        }

        // Fill DP table for substrings of increasing length
        for (int substringLength = 2; substringLength <= stringLength; substringLength++) {

            for (int startIndex = 0; startIndex <= stringLength - substringLength; startIndex++) {

                int endIndex = startIndex + substringLength - 1;

                if (inputString.charAt(startIndex) == inputString.charAt(endIndex)) {

                    if (substringLength == 2) {
                        dp[startIndex][endIndex] = 2;
                    } else {
                        dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                    }

                } else {
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }

        System.out.println("DP Table:");
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("The longest palindromic subsequence length = " + dp[0][stringLength - 1]);
    }
}
