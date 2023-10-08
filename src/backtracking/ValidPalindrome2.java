package backtracking;

/**
 *  https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(char[] chars, int start, int end) {
        while(start < end){
            if(chars[start] != chars[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        boolean isFaulty = false;

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length-1;

        while(start < end){
            if(chars[start] != chars[end]){
                return validPalindrome(chars, start+1, end) || validPalindrome(chars, start, end-1);
            }
            start++;
            end--;
        }
        return true;
    }
}
