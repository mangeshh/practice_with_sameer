package linked_list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/
 */
public class RemoveDupsFromLinkList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode deleteDuplicates(ListNode head) {

            ListNode currentNode = head;
            ListNode prevNode = null;

            while (currentNode != null) {

                if (prevNode != null && currentNode.val == prevNode.val) {
                    currentNode = currentNode.next;
                    continue;
                }
                if (prevNode != null) {
                    prevNode.next = currentNode;
                }
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            if (prevNode != null) {
                prevNode.next = null;
            }


            return head;

        }
    }