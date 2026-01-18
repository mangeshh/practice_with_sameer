package sliding_window;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {

        // Sample input we will dry‑run like a comic
        String inputString = "AABABBA";
        int maximumAllowedReplacements = 1;

        int result = findLongestRepeatingCharacterWindow(inputString, maximumAllowedReplacements);
        System.out.println("Longest valid window length = " + result);
    }

    public static int findLongestRepeatingCharacterWindow(String inputString, int maximumAllowedReplacements) {

        int[] characterFrequency = new int[26];

        int leftPointer = 0;
        int maximumFrequencyInsideWindow = 0;
        int longestValidWindowLength = 0;

        /*
         ---------------------------------------------------------
         COMIC‑STYLE DRY RUN WITH ACTUAL REPLACEMENTS

         String: A A B A B B A
                 0 1 2 3 4 5 6
         k = 1   → allowed to replace ONLY ONE character

         ---------------------------------------------------------
         r = 0 → window "A"
           already uniform → no replacement needed

         r = 1 → window "A A"
           already uniform → no replacement needed

         r = 2 → window "A A B"
           most freq = A (2 times)
           mismatches = 1 (the B)
           k = 1 → allowed
           actual replacement:
             A A B
                 ↑ replace B → A
           becomes: A A A   (valid window size = 3)

         r = 3 → window "A A B A"
           most freq = A (3 times)
           mismatches = 1 (the B)
           k = 1 → allowed
           actual replacement:
             A A B A
               ↑ replace B → A
           becomes: A A A A   (valid window size = 4)

         r = 4 → window "A A B A B"
           most freq = A (3 times)
           mismatches = 2 (two B’s)
           k = 1 → NOT allowed
           because:
             A A B A B
               ↑     ↑
             needs 2 replacements → but k=1
           → shrink window from left

         r = 5 → window "A B A B B"
           most freq = B (3 times)
           mismatches = 2 (two A’s)
           k = 1 → NOT allowed
           actual needed:
             A B A B B
             ↑   ↑
             needs 2 replacements → but k=1
           → shrink window

         r = 6 → window "B A B B A"
           most freq = B (3 times)
           mismatches = 2 (two A’s)
           k = 1 → NOT allowed
           → shrink window

         Longest valid window we ever saw = 4
         ---------------------------------------------------------
        */

        for (int rightPointer = 0; rightPointer < inputString.length(); rightPointer++) {

            char currentCharacter = inputString.charAt(rightPointer);
            characterFrequency[currentCharacter - 'A']++;

            maximumFrequencyInsideWindow = Math.max(
                    maximumFrequencyInsideWindow,
                    characterFrequency[currentCharacter - 'A']
            );

            int currentWindowSize = rightPointer - leftPointer + 1;
            int replacementsNeeded = currentWindowSize - maximumFrequencyInsideWindow;

            while (replacementsNeeded > maximumAllowedReplacements) {

                char leftCharacter = inputString.charAt(leftPointer);
                characterFrequency[leftCharacter - 'A']--;

                leftPointer++;

                currentWindowSize = rightPointer - leftPointer + 1;
                replacementsNeeded = currentWindowSize - maximumFrequencyInsideWindow;
            }

            longestValidWindowLength = Math.max(longestValidWindowLength, currentWindowSize);
        }

        return longestValidWindowLength;
    }
}
