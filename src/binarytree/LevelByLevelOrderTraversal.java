package binarytree;

import java.util.LinkedList;
import java.util.Queue;


public class LevelByLevelOrderTraversal {

    public static void levelByLevelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();

        q1.add(root);

        while (!q1.isEmpty() || !q2.isEmpty()) {

            while (!q1.isEmpty()) {
                Node node = q1.poll();
                System.out.print(" " + node.data);

                if (node.left != null) q2.add(node.left);
                if (node.right != null) q2.add(node.right);
            }
            System.out.println("");

            while (!q2.isEmpty()) {
                Node node = q2.poll();
                System.out.print(" " + node.data);

                if (node.left != null) {
                    q1.add(node.left);
                }
                if (node.right != null) {
                    q1.add(node.right);
                }
            }

            System.out.println("");

        }

    }


    public static void levelByLevelOrderTraversal1(Node root) {
        if (root == null) return;

        Queue<Node> q1 = new LinkedList<Node>();
        q1.add(root);
        int level = 0;

        while (!q1.isEmpty()) {
            level = q1.size();

            while (level > 0) {
                Node node = q1.poll();
                System.out.print(" " + node.data);
                if (node.left != null) q1.add(node.left);
                if (node.right != null) q1.add(node.right);
                level = level - 1;
            }
            System.out.println("");
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

        levelByLevelOrderTraversal(node);
        System.out.println(" ");
        levelByLevelOrderTraversal1(node);

    }

}
