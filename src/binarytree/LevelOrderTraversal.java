package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void traverse(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(" " + node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
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

		/*      	10
		 *  	11		12
		 *     13 14  15 16
		 *     17 
		 */

        LevelOrderTraversal traversal = new LevelOrderTraversal();
        traversal.traverse(node);


    }

}
