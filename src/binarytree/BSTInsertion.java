package binarytree;

public class BSTInsertion {

    public static Node insertIntoBST(Node root, int data) {

        Node node = new Node(data);
        if (root == null) {
            return node;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            parent = current;
            if (current.data <= data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (parent.data <= data) {
            parent.right = node;
        } else {
            parent.left = node;
        }

        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node root = BSTInsertion.insertIntoBST(null, 10);
        Node node1 = BSTInsertion.insertIntoBST(root, 12);
        Node node2 = BSTInsertion.insertIntoBST(node1, 21);
        Node node3 = BSTInsertion.insertIntoBST(node2, 19);
        Node node4 = BSTInsertion.insertIntoBST(node3, 101);
        Node node5 = BSTInsertion.insertIntoBST(node4, 121212);
        Node node6 = BSTInsertion.insertIntoBST(node5, 1);
        Node node7 = BSTInsertion.insertIntoBST(node6, 2);


        LevelOrderTraversal.traverse(root);


    }

}
