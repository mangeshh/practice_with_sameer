package array;

/**
 * https://leetcode.com/problems/valid-anagram/submissions/
 */
public class Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26]; // Assuming only lowercase English letters

        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        boolean b = isAnagram("triangleaa", "integralaaa");
        System.out.println(b);
    }

}
