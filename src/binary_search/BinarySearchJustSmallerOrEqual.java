package binary_search;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchJustSmallerOrEqual {

    List<Integer> list = new ArrayList<>();

    public int search(int target) {
        int low = 0;
        int high = list.size();
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) > target) {
                high = mid - 1;
            } else {
                System.out.println("current closest smallest " + list.get(mid));
                answer = mid;// recording the closest number.
                low = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        binary_search.BinarySearchJustSmallerOrEqual b = new binary_search.BinarySearchJustSmallerOrEqual();
        b.list.add(1);
        b.list.add(2);
        b.list.add(3);
        b.list.add(7);
        b.list.add(19);
        b.list.add(22);
        int ans = b.search(4);
        System.out.println(ans);
    }
}
