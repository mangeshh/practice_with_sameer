package linked_list;

public class SwapAdjNodes {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;  // 1 variable
        ListNode prevPairLastNode = null;  // 2nd variable
        ListNode firstNode = head;   // 3rd variable

        while (firstNode != null && firstNode.next != null) {
            ListNode secondNode = firstNode.next;  // 4th variable
            ListNode nextPairHeadNode = firstNode.next.next; // 5th var.

            if (prevPairLastNode != null) {
                prevPairLastNode.next = secondNode; // here (this will come in 2nd iteration, because we have to get 4 assign to 1.
            }

            secondNode.next = firstNode; // swapping happening here. first is now becoming second
            firstNode.next = nextPairHeadNode; // now 1st node is 2nd node of pair so, new pair head is first.next
            prevPairLastNode = firstNode; // now 1st node is last node of prev pair.
            firstNode = nextPairHeadNode; // now for iteration get the new pair head now, so assign it to first node.
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode firstNode = new ListNode();
        firstNode.val = 1;
        ListNode secondNode = new ListNode();
        secondNode.val = 2;
        ListNode thirdNode = new ListNode();
        thirdNode.val = 3;
        ListNode fourthNode = new ListNode();
        fourthNode.val = 4;

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;

        ListNode swappedNode = swapPairs(firstNode);

        while (swappedNode != null){
            System.out.println(swappedNode.val);
            swappedNode = swappedNode.next;
        }
    }
}