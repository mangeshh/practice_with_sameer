package heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        // 3, 2, 1, 5, 0
        // 3, 2, 1, 5, 0
        // heap.peek() will give me the smallest element
        // heap.push(x) will insert x into the heap     O(log n)
        // heap.poll() will remove the smallest element     O(log n)

        // where n is the current size of the heap


        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // By default it is a min heap only

        // Min heap matlab top pe sabse smallest aur remove bhi smallest hi hoga (peek and poll)

        // 3, 5
        // time complexity is n (interation of nums) * logK (heap has max k element so log k).
        for (int x : nums) {
            minHeap.add(x);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();

    }

    public static void main(String[] args) {
        findKthLargest(new int[] {3,2,1,4,5}, 2);
    }
}