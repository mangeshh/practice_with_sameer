package heap;

/*
    If it is a min-heap, then the value of node should be less than both, the left and right child.
    Min-heap is internally implemented using BINARY tree only

    binary tree is called min-heap when both of its value is less than both children (left and right)
    (this property should be satisfied for all the nodes in the tree just like BST)

     5
   6  4

   is not a min-heap

     5
   6  7

   is a min-heap

            1
        2      3
     7       8

     There are some restrictions that binary tree has to satisfy while being used to implement min-heap

        a.  All the nodes in the current level should be filled before moving to the next level.

                 1
              2
            3

         This is not a valid binary tree to be considered for implementing heap

       b. While inserting nodes in the current level we should maintain the order from left to right

              5
                6
         This is not a valid binary tree to be considered for implementing heap

         Because 6 should ideally be made the left child of 7 and not right




         Let's take a valid min-heap for example

                  3
               5     4
             6  9  8  7

          Let's just go from left to right and list down all the values of heap:

            Index:              0 1 2 3 4 5 6
            Values of heap:     3 5 4 6 9 8 7


         Whenever we construct a tree considering point a. and point b. above, there is a unique formula that exists:

                For any node at index i:

                    * Its parent index is given by:            (i - 1) / 2
                    * It's left child index is given by:       2 * i + 1
                    * It's right child index is given by:      2 * i + 2



         Let's take a stream of integers and create a min-heap of it:

                7, 8, 9, 2

         Simulation:

         1. 7 comes up:

                7

        2. 8 comes up:

                7
             8

        3.  9 comes up:

                7
             8    9

       4. 2 comes up

            So we should just put the new element in the desired position according to rules a. and b.
            In this case 2 should be inserted as a left child of 8.


                7
             8    9
          2

          Now after inserting the new element (2) we will check if its "PARENT" (8) still satisfies the
          min heap property or not.

          In this case it doesn't, so we just swap new_element with the parent.


                7
             2    9
          8

          Now we will check again with new parent of 2 which is 7. We swap again


                2
             7    9
          8

          Now, it satisfies so we stop.

          This process of going upwards until it satisfies is called as heapifyUp algorithm.





          Now let's say we want to perform poll operation (which means removing minimum that is 2)

          We just replace 2 with the last element of the heap (8)
          We also decrease the size by 1.


                8
             7    9
          8

          It seems like our heap Array contains 2 8s but in reality since we have also decreased size by one.
          So the last one is 9 (index 2) and not 8.

          Ideally 8 should be less than 7 and 9. But it isn't so we swap 8 with the smaller of left and right child.


                7
             8    9
          8

         Now 8 (index 1) has no left and right child so everything is sorted now we stop.

         Now 2 has been removed.





 */

import java.util.Arrays;

class MinHeap {
    private int[] heapArray;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heapArray = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int element) {
        if (this.size >= this.capacity) {
            System.out.println("Sorry, we cannot insert any new element! Overflow!");
            return;
        }
        this.heapArray[size] = element;
        this.size++;
        heapifyUp(this.size - 1);
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Sorry, we do not have any element in heap! Underflow!");
            return -1;
        }
        return this.heapArray[0];
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        while (index > 0 && this.heapArray[index] < this.heapArray[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void swap(int i, int j) {
        int temp = this.heapArray[i];
        this.heapArray[i] = this.heapArray[j];
        this.heapArray[j] = temp;
    }

    public void showHeap() {
        System.out.println("HeapArray: " + Arrays.toString(this.heapArray));
    }


    public static void main(String[] args) {
        MinHeap heap = new MinHeap(20);
        heap.push(7);
        heap.push(8);
        heap.push(9);
        heap.showHeap();
        heap.push(2);
        heap.showHeap();
        System.out.println(heap.peek());

    }
}

