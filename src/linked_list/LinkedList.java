package linked_list;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class LinkedList {

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addLast(int element) {

        if (head == null) {
            head = new Node(element);
            return;
        }

        Node currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node(element);

    }

    public void addAtPosition(int position, int element) {
    /*
        Comic-style explanation:

        We want to insert a node at a specific position.

        Example:
            List: 1 → 2 → 3 → 4
            addAtPosition(2, 99)

            Result: 1 → 2 → 99 → 3 → 4

        Edge Cases:
        - position == 0 → same as addFirst
        - position > length → insert at end
        - position < 0 → invalid
    */

    if (position < 0) {
        System.out.println("Invalid position: " + position);
        return;
    }

    Node newNode = new Node(element);

    // Case 1: Insert at beginning
    if (position == 0) {
        newNode.next = head;
        head = newNode;
        return;
    }

    Node currentNode = head;
    int currentIndex = 0;

    // Traverse to the node just before the desired position
    while (currentNode != null && currentIndex < position - 1) {
        currentNode = currentNode.next;
        currentIndex++;
    }

    // Case 2: Position is beyond current length → insert at end
    if (currentNode == null) {
        System.out.println("Position is beyond list length. Adding at end.");
        addLast(element);
        return;
    }

    // Insert the new node
    newNode.next = currentNode.next;
    currentNode.next = newNode;
}

    public void addFirst(int element) {

        if (head == null) {
            head = new Node(element);
            return;
        }

        Node newNode = new Node(element);

        newNode.next = head;
        head = newNode;

    }

    public void display() {
        Node currentNode = head;
        System.out.println("the Linkedlist is : ");
        while(currentNode!= null){
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


    public void delete(int element) {
        if(head == null){
            System.out.println("no element available in list to delete.");
            return;
        }

        if(head.val == element){
            head = head.next;
            return;
        }

        Node currentNode = head;
        Node prev = null;

        while(currentNode.next!= null){
            if(currentNode.next.val == element){
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }
    }


    public boolean search(int element) {
        Node currentNode = head;

        while(currentNode!= null){
            if(currentNode.val == element){
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.display();
        list.addFirst(0);
        list.display();
        list.delete(0);
        list.display();
        list.delete(2);
        list.display();
        System.out.println(list.search(1));
        System.out.println(list.search(11));

        list.addAtPosition(2, 99); // Insert 99 at position 2 
        list.display(); 
        list.addAtPosition(0, 77); // Insert 77 at beginning 
        list.display(); 
        list.addAtPosition(2, 88); // Insert 88 beyond length → goes to end 
        list.display();
    }
}
