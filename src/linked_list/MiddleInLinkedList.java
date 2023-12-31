package linked_list;


class ListNode {
    int val;
    ListNode next;

}

public class MiddleInLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode twoStep = head;
        ListNode singleStep = head;

        while(twoStep != null){
            twoStep = twoStep.next;
            if(twoStep != null){
                twoStep = twoStep.next;
            } else{
                // end of the list.
                break;

            }

            singleStep = singleStep.next;

        }

        return singleStep;
    }
}
