package binarytree;

public class SizeBinaryTree {

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        int lht = size(root.left);
        int rht = size(root.right);

        return lht + rht + 1;

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

        int size = size(node);
        System.out.println("size " + size);

    }

}
