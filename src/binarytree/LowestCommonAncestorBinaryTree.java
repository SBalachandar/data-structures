package binarytree;

public class LowestCommonAncestorBinaryTree {

    public static Node LCA(Node root, Node n1, Node n2) {
        if (root == null) return null;

        if (root.data == n1.data || root.data == n2.data) return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node root = new Node(10);
        root.left = new Node(-10);
        root.left.right = new Node(8);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(9);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.right = new Node(60);
        root.right.left.right = new Node(28);
        root.right.right.right = new Node(78);

        Node lcaNode = LCA(root, new Node(28), new Node(78));

        LevelByLevelOrderTraversal.levelByLevelOrderTraversal1(root);
        System.out.println("lcaNode  " + lcaNode.data);

    }

}
