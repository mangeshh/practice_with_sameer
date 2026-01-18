package linked_list;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    // Insert at the beginning
    public void insertAtHead(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise attach before head
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Insert at the end
    public void insertAtTail(int data) {

        Node newNode = new Node(data);

        // If list is empty
        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    // Delete a node by value
    public void deleteNode(int value) {

        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        // Case 1: delete head
        if (head.data == value) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }

        Node currentNode = head;

        while (currentNode != null && currentNode.data != value) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) {
            System.out.println("Value not found.");
            return;
        }

        // Remove currentNode
        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        }

        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        }
    }

    // Display list forward
    public void printForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display list backward
    public void printBackward() {

        if (head == null) {
            System.out.println("Backward: (empty)");
            return;
        }

        Node temp = head;

        // Go to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /*
            Comic-style dry run:

            Insert at head: 3
            Insert at head: 2
            Insert at head: 1

            List: 1 <-> 2 <-> 3

            Insert at tail: 4
            Insert at tail: 5

            List: 1 <-> 2 <-> 3 <-> 4 <-> 5

            Delete 3

            List: 1 <-> 2 <-> 4 <-> 5
        */

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtHead(3);
        dll.insertAtHead(2);
        dll.insertAtHead(1);

        dll.insertAtTail(4);
        dll.insertAtTail(5);

        dll.printForward();
        dll.printBackward();

        dll.deleteNode(3);

        dll.printForward();
        dll.printBackward();
    }
}
