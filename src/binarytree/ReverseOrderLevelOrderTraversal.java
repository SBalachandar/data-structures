package binarytree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class ReverseOrderLevelOrderTraversal {

    public static void reverseOrderLevelOrderTreeTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q1 = new LinkedList<Node>();
        Stack<Node> s1 = new Stack<Node>();

        q1.add(root);

        while (!q1.isEmpty()) {
            Node node = q1.poll();
            s1.push(node);
            if (node.left != null) {
                q1.add(node.left);
            }

            if (node.right != null) {
                q1.add(node.right);
            }
        }

        while (!s1.isEmpty()) {
            Node node = s1.pop();
            System.out.print(" " + node.data);
        }

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node node = new Node(10);
        node.left = new Node(11);
        node.right = new Node(12);
        node.left.left = new Node(13);
        node.left.right = new Node(14);
        node.right.left = new Node(15);
        node.right.right = new Node(16);
        node.left.left.left = new Node(17);
        reverseOrderLevelOrderTreeTraversal(node);
        System.out.println();

    }

}
