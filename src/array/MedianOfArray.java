package array;

/**
 *  https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfArray {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int newLength = nums1.length + nums2.length;
        int[] mergedArray = new int[newLength];
        int k = 0;
        int i = 0; //counter for nums1
        int j = 0; // counter for nums2
        Double answer = null;

        // num1 and num2 are sorted and now we will make mergedArray as final sorted array.
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

        // median of array - core logic.
        if (mergedArray.length % 2 == 0) {
            answer = (double) (mergedArray[(newLength / 2 - 1)] + mergedArray[(newLength / 2)]) / 2;
        } else {
            answer = (double) mergedArray[(newLength / 2)];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3,5}, new int[]{2,3}));
    }
}

