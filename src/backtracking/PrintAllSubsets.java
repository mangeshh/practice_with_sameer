package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * main to start - actual backtracking.
 */
public class PrintAllSubsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(0, new ArrayList<>(), subsets, nums);
        return subsets;
    }

    // This will generate all subsets with elements starting from currentIndex, having previous subset as previousSubset
    public static void backtrack(int currentIndex, ArrayList<Integer> previousSubset, List<List<Integer>> subsets, int[] nums) {
        System.out.println("backtrack(" + currentIndex + ", " + previousSubset + ")" );
        if (currentIndex == nums.length) {
            System.out.println("                             Adding " + previousSubset);
            subsets.add(new ArrayList<>(previousSubset));
            System.out.println("based condition matched so returning!!!!");
            return;
        }

        previousSubset.add(nums[currentIndex]); // 1 ; 2; 4; 8
        backtrack(currentIndex + 1, previousSubset, subsets, nums);

        int removedElement = previousSubset.remove(previousSubset.size() - 1); // remove 8
        System.out.println("                             Removing from previousSubset " + removedElement);
        backtrack(currentIndex + 1, previousSubset, subsets, nums); // 4, (1,2,4), (ans, (input);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 8};

        List<List<Integer>> subsets = findSubsets(nums);
        System.out.println("answer is " + subsets);
    }
}


