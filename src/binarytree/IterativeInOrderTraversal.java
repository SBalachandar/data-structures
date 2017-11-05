package binarytree;


import java.util.Stack;

public class IterativeInOrderTraversal {

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) inOrder(root.left);
        System.out.print(" " + root.data);
        if (root.right != null) inOrder(root.right);

    }

    public static void inOrderIterative(Node root) {

        if (root == null) return;

        Stack<Node> s1 = new Stack<Node>();

        while (true) {
            if (root != null) {
                s1.push(root);
                root = root.left;

            } else {
                if (s1.isEmpty()) break;
                root = s1.pop();
                System.out.print(" " + root.data);
                root = root.right;
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


        inOrder(root);
        System.out.println(" print iteratively ");
        inOrderIterative(root);


    }

}
