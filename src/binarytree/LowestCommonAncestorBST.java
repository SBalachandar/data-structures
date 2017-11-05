package binarytree;


public class LowestCommonAncestorBST {


    public static Node lcaBST(Node root, Node n1, Node n2) {
        if (root == null || n1 == null || n2 == null) {
            return null;
        }

        if (root.data > Math.max(n1.data, n2.data)) {
            return lcaBST(root.left, n1, n2);
        } else if (root.data < Math.min(n1.data, n2.data)) {
            return lcaBST(root.right, n1, n2);
        } else {
            return root;
        }

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

        Node lcaNode = lcaBST(root, new Node(28), new Node(78));

        LevelByLevelOrderTraversal.levelByLevelOrderTraversal1(root);
        System.out.println("lcaNode  " + lcaNode.data);


    }

}
