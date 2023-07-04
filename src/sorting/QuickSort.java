package sorting;// Java program for implementation of QuickSort

import java.util.Arrays;

public class QuickSort {

    /**
     * important : `i` and `j` are important, `i` is used for keeping track of smaller element and j is for iteration
     *             to find smaller element and assign at ith index.)
     *
     * 1. We initialize a variable `i` to low - 1
     *    to keep track of the position where elements smaller than the pivot will be placed.
     *
     * 2. We iterate from low to high-1 using a variable `j` to compare each element with the pivot.
     *
     * 3. Inside the loop, if the current element at j is smaller than the pivot,
     *    we increment i and swap the elements at positions i and j.
     *    This ensures that all elements smaller than the pivot are placed before it.
     *
     *
     */
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // we are starting i, from one index before.

        for (int j = low; j < high; j++) {
             if (arr[j] <= pivot) {
                i++;
                // in 1st attempt it will replace 0 with 0, if oth index is smaller than pivot.
                swap(arr, i, j);
            }
        }
        int pivot_position = i + 1;
        swap(arr, pivot_position, high);
        return pivot_position;
    }

    public static void sort(int arr[], int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high); // pivot position.
            sort(arr, low, mid - 1);
            sort(arr, mid + 1, high);
        }
    }

     public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        QuickSort.sort(arr, 0, arr.length - 1);
        System.out.println("sorted array " + Arrays.toString(arr));
    }

     static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
