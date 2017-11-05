package linkedlist;

public class LinkedList {

    Node head;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        list.append(30);
        list.printList();

        System.out.println("\n Inserting at end");
        list.insertEnd(40);
        list.insertEnd(50);
        list.printList();
        System.out.println("\n ");
        list.insert(list.head, 100);
        list.printList();
        System.out.println("\n ");

        list.deleteNode(100);
        list.printList();
        System.out.println("\n ");

        int length = list.length();
        System.out.println("leng " + length);

        int lengthR = list.lengthRecurvise();
        System.out.println("leng " + lengthR);
        //list.printList();


    }

    // Time Complex O(1)
    public void append(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    //Time Complex O(n)
    public void insert(Node node, int value) {

        if (node == null) return;

        Node newNode = new Node(value);
        newNode.next = node.next;
        node.next = newNode;
        return;
    }

    public void insertEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        return;
    }

    public void deleteIndex(int data) {
    }

    public int length() {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public int lengthRecurvise() {
        return lengR(head);
    }

    private int lengR(Node node) {
        if (node == null)
            return 0;
        return 1 + lengR(node.next);
    }

    public void deleteNode(int position) {
        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.next;   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(" " + node);
            node = node.next;
        }
    }

    class Node {
        Node next;
        int data;

        Node(int d) {
            this.data = d;
            this.next = null;
        }

        public String toString() {
            return " " + data;
        }
    }

}
