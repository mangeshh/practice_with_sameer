package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitBasketSlidingWindowDryRun {

    public static void main(String[] args) {

        // Sample input (hardcoded)
        // Trees: 1 2 1 2 3 2 2 1
        // We will walk through this input step-by-step in comments.
        int[] fruitTypeAtEachTree = {1, 2, 1, 2, 3, 2, 2, 1};

        int answer =
                maximumNumberOfFruitsCollectedWithAtMostTwoFruitTypes(fruitTypeAtEachTree);

        System.out.println("Maximum fruits you can collect = " + answer);
    }


    public static int maximumNumberOfFruitsCollectedWithAtMostTwoFruitTypes(int[] fruitTypeAtEachTree) {

        Map<Integer, Integer> fruitTypeToCountInsideCurrentWindow = new HashMap<>();

        int leftBoundaryOfWindow = 0;
        int maximumWindowSizeWithValidFruitTypes = 0;

        // -------------------------------
        // DRY RUN FOR INPUT: 1 2 1 2 3 2 2 1
        // -------------------------------

        for (int rightBoundaryOfWindow = 0;
             rightBoundaryOfWindow < fruitTypeAtEachTree.length;
             rightBoundaryOfWindow++) {

            int currentFruitTypeAtRightBoundary = fruitTypeAtEachTree[rightBoundaryOfWindow];

            // Add fruit at right boundary
            fruitTypeToCountInsideCurrentWindow.put(
                    currentFruitTypeAtRightBoundary,
                    fruitTypeToCountInsideCurrentWindow.getOrDefault(currentFruitTypeAtRightBoundary, 0) + 1
            );

            // -------------------------------
            // COMMENTARY: WHAT HAPPENS EACH ITERATION
            // -------------------------------
            // Example for each iteration:
            //
            // right = 0 → fruit = 1
            // Window = [1]
            // Map = {1=1}
            // Valid (only 1 type)
            //
            // right = 1 → fruit = 2
            // Window = [1,2]
            // Map = {1=1, 2=1}
            // Valid (2 types)
            //
            // right = 2 → fruit = 1
            // Window = [1,2,1]
            // Map = {1=2, 2=1}
            // Valid (2 types)
            //
            // right = 3 → fruit = 2
            // Window = [1,2,1,2]
            // Map = {1=2, 2=2}
            // Valid (2 types)
            //
            // right = 4 → fruit = 3
            // Window = [1,2,1,2,3]
            // Map = {1=2, 2=2, 3=1}
            // INVALID (3 types) → shrink from left
            //
            // Shrink:
            // Remove left=1 → Map becomes {1=1,2=2,3=1}
            // Still 3 types → move left again
            // Remove left=2 → Map becomes {1=1,2=1,3=1}
            // Still 3 types → move left again
            // Remove left=1 → Map becomes {2=1,3=1}
            // Now valid (2 types)
            //
            // Window now effectively = [2,3]
            //
            // right = 5 → fruit = 2
            // Window = [2,3,2]
            // Map = {2=2, 3=1}
            // Valid
            //
            // right = 6 → fruit = 2
            // Window = [2,3,2,2]
            // Map = {2=3, 3=1}
            // Valid
            //
            // right = 7 → fruit = 1
            // Window = [2,3,2,2,1]
            // Map = {2=3, 3=1, 1=1}
            // INVALID → shrink again
            //
            // Remove left=2 → Map {2=2,3=1,1=1}
            // Still 3 types → shrink
            // Remove left=3 → Map {2=2,1=1}
            // Valid
            //
            // Final max window = 4 (from [1,2,1,2] or [2,3,2,2])
            // -------------------------------


            // Shrink window if more than 2 fruit types
            while (fruitTypeToCountInsideCurrentWindow.size() > 2) {

                int fruitTypeAtLeftBoundary = fruitTypeAtEachTree[leftBoundaryOfWindow];

                fruitTypeToCountInsideCurrentWindow.put(
                        fruitTypeAtLeftBoundary,
                        fruitTypeToCountInsideCurrentWindow.get(fruitTypeAtLeftBoundary) - 1
                );

                if (fruitTypeToCountInsideCurrentWindow.get(fruitTypeAtLeftBoundary) == 0) {
                    fruitTypeToCountInsideCurrentWindow.remove(fruitTypeAtLeftBoundary);
                }

                leftBoundaryOfWindow++;
            }

            int currentWindowSize =
                    rightBoundaryOfWindow - leftBoundaryOfWindow + 1;

            maximumWindowSizeWithValidFruitTypes =
                    Math.max(maximumWindowSizeWithValidFruitTypes, currentWindowSize);
        }

        return maximumWindowSizeWithValidFruitTypes;
    }
}
