package binarytree;

import java.util.Stack;

public class SprialOrderPrintBinaryTree {


    public static void printSprialOrderTree(Node root) {
        if (root == null) return;

        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            System.out.println("");

            while (!s1.isEmpty()) {
                Node node = s1.pop();
                System.out.print(" " + node.data);
                if (node.left != null) s2.push(node.left);
                if (node.right != null) s2.push(node.right);

            }
            System.out.println("");

            while (!s2.isEmpty()) {
                Node node = s2.pop();
                System.out.print(" " + node.data);
                if (node.right != null) s1.push(node.right);
                if (node.left != null) s1.push(node.left);
            }
        }
        System.out.println("");


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
        LevelByLevelOrderTraversal.levelByLevelOrderTraversal1(node);
        printSprialOrderTree(node);
    }

}
