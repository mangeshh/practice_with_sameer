package binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/number-of-recent-calls/
 */
public class FindRecentCalls {

    List<Integer> list = new ArrayList<>();

    public FindRecentCalls() {

    }

    public int binarySearch(int target) {
        int low = 0;
        int high = list.size();
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }
        return answer;
    }

    public int ping(int t) {
        list.add(t);
        int reference = Math.max(0, t - 3000);
        int mid = binarySearch(reference);
        return list.size() - mid;

    }

}
