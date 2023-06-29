package sorting;

import java.util.ArrayList;

public class MergeSort {
    public static void merge(int left, int right, ArrayList<Integer> a){
        int mid = (left + right) / 2;
        // left, mid - LeftSubArray
        // mid+1, right - RightSubArray

        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        for(int i = left; i <= mid; ++i){
            leftArray.add(a.get(i));
        }

        for(int i = mid + 1; i <= right; ++i){
            rightArray.add(a.get(i));
        }

        int l = 0, r = 0, index = left;

        while(l < leftArray.size() && r < rightArray.size()){
            if(leftArray.get(l) < rightArray.get(r)){
                a.set(index, leftArray.get(l));
                ++l;
            }
            else {
                a.set(index, rightArray.get(r));
                ++r;
            }
            index++;
        }

        while(l < leftArray.size()){
            a.set(index, leftArray.get(l));
            ++index;
            ++l;
        }

        while(r < rightArray.size()){
            a.set(index, rightArray.get(r));
            ++index;
            ++r;
        }

    }

    public static void mergeSort(int left, int right, ArrayList<Integer> a){
        if(left > right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(left, mid, a);
        mergeSort(mid + 1, right, a);

        System.out.println(left + " " + right);
        merge(left, right, a);
        System.out.println(a);
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(6);
        a.add(5);

        mergeSort(0, a.size() - 1, a);

    }
}
