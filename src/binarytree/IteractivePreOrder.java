package binarytree;

import java.util.Stack;

public class IteractivePreOrder {


    public static void preOrder(Node root) {
        if (root == null) return;

        System.out.print(" " + root.data);
        if (root.left != null) preOrder(root.left);
        if (root.right != null) preOrder(root.right);
    }

    public static void preOrderIterative(Node root) {
        if (root == null) return;

        Stack<Node> s1 = new Stack<Node>();

        s1.push(root);

        while (!s1.isEmpty()) {
            Node node = s1.pop();
            System.out.print(" " + node.data);

            if (node.right != null) {
                s1.push(node.right);
            }

            if (node.left != null) {
                s1.push(node.left);
            }
        }


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node root = new Node(10);
        root.left = new Node(12);
        root.left.left = new Node(14);
        root.left.left.left = new Node(16);
        root.right = new Node(13);

        System.out.println("pring preOrder ");
        preOrder(root);
        System.out.println("pring preOrder Iterative ");
        preOrderIterative(root);


    }

}
