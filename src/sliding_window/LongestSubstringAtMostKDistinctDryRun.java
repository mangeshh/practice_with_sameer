package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostKDistinctDryRun {

    public static void main(String[] args) {

        // Hardcoded sample input
        // String: "aabacbebebe"
        // K = 3
        //
        // We will walk through this input step-by-step in comments.
        String inputString = "aabacbebebeaabacbebebe";
        int maximumAllowedDistinctCharacters = 3;

        int answer =
                longestSubstringWithAtMostKDistinctCharacters(
                        inputString,
                        maximumAllowedDistinctCharacters
                );

        System.out.println("Longest substring length = " + answer);
    }


    public static int longestSubstringWithAtMostKDistinctCharacters(
            String inputString,
            int maximumAllowedDistinctCharacters) {

        Map<Character, Integer> characterToFrequencyInsideWindow = new HashMap<>();

        int leftBoundaryOfWindow = 0;
        int maximumWindowSizeFoundSoFar = 0;

        // ---------------------------------------------------------
        // DRY RUN FOR INPUT: "aabacbebebe", K = 3
        // ---------------------------------------------------------
        //
        // right=0 → 'a'
        // Window = "a"
        // Map = {a=1}
        // Valid (1 distinct)
        //
        // right=1 → 'a'
        // Window = "aa"
        // Map = {a=2}
        // Valid
        //
        // right=2 → 'b'
        // Window = "aab"
        // Map = {a=2, b=1}
        // Valid (2 distinct)
        //
        // right=3 → 'a'
        // Window = "aaba"
        // Map = {a=3, b=1}
        // Valid
        //
        // right=4 → 'c'
        // Window = "aabac"
        // Map = {a=3, b=1, c=1}
        // Valid (3 distinct)
        //
        // right=5 → 'b'
        // Window = "aabacb"
        // Map = {a=3, b=2, c=1}
        // Valid (3 distinct)
        //
        // right=6 → 'e'
        // Window = "aabacbe"
        // Map = {a=3, b=2, c=1, e=1}
        // INVALID (4 distinct) → shrink from left
        //
        // Shrink:
        // remove 'a' → Map {a=2,b=2,c=1,e=1}
        // still 4 distinct → shrink
        // remove 'a' → Map {a=1,b=2,c=1,e=1}
        // still 4 → shrink
        // remove 'b' → Map {a=1,b=1,c=1,e=1}
        // still 4 → shrink
        // remove 'a' → Map {b=1,c=1,e=1}
        // Now valid (3 distinct)
        //
        // Window now = "cbe"
        //
        // right=7 → 'b'
        // Window = "cbeb"
        // Map = {c=1,b=2,e=1}
        // Valid
        //
        // right=8 → 'e'
        // Window = "cbebe"
        // Map = {c=1,b=2,e=2}
        // Valid
        //
        // right=9 → 'b'
        // Window = "cbebeb"
        // Map = {c=1,b=3,e=2}
        // Valid
        //
        // right=10 → 'e'
        // Window = "cbebebe"
        // Map = {c=1,b=3,e=3}
        // Valid
        //
        // Final max window = 7 ("cbebebe")
        // ---------------------------------------------------------

        for (int rightBoundaryOfWindow = 0;
             rightBoundaryOfWindow < inputString.length();
             rightBoundaryOfWindow++) {

            char currentCharacterAtRightBoundary = inputString.charAt(rightBoundaryOfWindow);

            characterToFrequencyInsideWindow.put(
                    currentCharacterAtRightBoundary,
                    characterToFrequencyInsideWindow.getOrDefault(currentCharacterAtRightBoundary, 0) + 1
            );
            System.out.println("leftBoundaryOfWindow  " + leftBoundaryOfWindow);

            // Shrink window if too many distinct characters
            while (characterToFrequencyInsideWindow.size() >
                    maximumAllowedDistinctCharacters) {

                char characterAtLeftBoundary = inputString.charAt(leftBoundaryOfWindow);

                characterToFrequencyInsideWindow.put(
                        characterAtLeftBoundary,
                        characterToFrequencyInsideWindow.get(characterAtLeftBoundary) - 1
                );

                if (characterToFrequencyInsideWindow.get(characterAtLeftBoundary) == 0) {
                    characterToFrequencyInsideWindow.remove(characterAtLeftBoundary);
                }

                leftBoundaryOfWindow++;
            }
            int currentWindowSize =
                    rightBoundaryOfWindow - leftBoundaryOfWindow + 1;

            maximumWindowSizeFoundSoFar =
                    Math.max(maximumWindowSizeFoundSoFar, currentWindowSize);
        }

        return maximumWindowSizeFoundSoFar;
    }
}
