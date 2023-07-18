package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {


    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(0, new ArrayList<>(), subsets, nums);
        return subsets;
    }

    //    This will generate all subsets with elements starting from currentIndex
    public static void backtrack(int currentIndex, ArrayList<Integer> previousSubset, List<List<Integer>> subsets, int[] nums) {

        if (currentIndex == nums.length) {
            subsets.add(new ArrayList<>(previousSubset));
            return;
        }

        previousSubset.add(nums[currentIndex]);
        backtrack(currentIndex + 1, previousSubset, subsets, nums);

        previousSubset.remove(previousSubset.size() - 1);
        backtrack(currentIndex + 1, previousSubset, subsets, nums);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 4, 9};

        List<List<Integer>> subsets = findSubsets(nums);
        System.out.println(subsets);
    }
}


