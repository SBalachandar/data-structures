package binarytree;

import java.util.Stack;

public class IterativePostOrderTraversal {


    public static void postOrder(Node root) {
        if (root == null) return;

        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) postOrder(root.right);
        System.out.print(" " + root.data);
    }

    public static void postOrderIterative(Node root) {

        if (root == null) return;

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node node = s1.pop();
            s2.push(node);

            if (node.left != null) {
                s1.push(node.left);
            }

            if (node.right != null) {
                s1.push(node.right);
            }
        }

        while (!s2.isEmpty()) {
            Node node = s2.pop();
            System.out.print(" " + node.data);
        }

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node root = new Node(10);
        root.left = new Node(12);
        root.left.left = new Node(14);
        root.left.left.left = new Node(16);
        root.right = new Node(13);
        root.right.right = new Node(15);

        postOrder(root);
        System.out.println("printing iterative");
        postOrderIterative(root);

    }

}
