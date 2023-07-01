package sorting;


import java.util.Arrays;

public class MergeSortedArrays {

    public static int[] sortArrays(int[] nums1, int[] nums2) {

        int newLength = nums1.length + nums2.length;
        int[] mergedArray = new int[newLength];
        int k = 0;
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[k++] = nums1[i++];
            } else {
                mergedArray[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            mergedArray[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            mergedArray[k++] = nums2[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrays(new int[]{1,3,5}, new int[]{2,3})));
    }
}
