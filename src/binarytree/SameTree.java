package binarytree;

public class SameTree {

    public static boolean isSame(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.data == root2.data && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Node root1 = BSTInsertion.insertIntoBST(null, 10);
        Node node1 = BSTInsertion.insertIntoBST(root1, 12);
        Node node2 = BSTInsertion.insertIntoBST(node1, 13);

        //Root2
        Node root2 = BSTInsertion.insertIntoBST(null, 10);
        Node node21 = BSTInsertion.insertIntoBST(root2, 12);
        Node node22 = BSTInsertion.insertIntoBST(node21, 13);

        boolean isSame = isSame(root1, root2);
        System.out.println("isSame " + isSame);

        Node node23 = BSTInsertion.insertIntoBST(node22, 14);
        boolean isSame1 = isSame(root1, root2);
        System.out.println("isSame1 " + isSame1);


    }

}
