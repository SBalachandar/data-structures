package binarytree;

public class HeightBinaryTree {

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lht = height(root.left);
        int rht = height(root.right);

        return Math.max(lht, rht) + 1;

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

        int ht = height(node);
        System.out.println("ht " + ht);
    }

}
