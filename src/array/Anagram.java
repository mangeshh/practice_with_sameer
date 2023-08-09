package array;

/**
 * https://leetcode.com/problems/valid-anagram/submissions/
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Array to store character frequencies

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++; // Increment count for character in s
        }

        for (char c : t.toCharArray()) {
            if (charCount[c - 'a'] == 0) {
                return false; // If count becomes negative, the strings can't be anagrams
            }
            charCount[c - 'a']--; // Decrement count for character in t
        }

        return true; // If all character counts match, the strings are anagrams
    }


}
