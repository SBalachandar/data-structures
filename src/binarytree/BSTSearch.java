package binarytree;

public class BSTSearch {

    public static Node search(Node root, int key) {

        if (root == null) return null;

        if (root.data == key) return root;

        if (root.data < key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
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

        Node result = BSTSearch.search(node, 45);

        if (result != null) {
            System.out.println(result.data);
        }

    }

}
