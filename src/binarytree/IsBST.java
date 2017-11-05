package binarytree;

public class IsBST {


    public static boolean isBST(Node root, int min, int max) {

        if (root == null) return true;

        if (root.data <= min || root.data > max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*
		 *       10
		 *     10  17 
		 *   -5  12 19
		 */

        Node root = new Node(10);
        root.left = new Node(10);
        root.left.left = new Node(-5);
        root.right = new Node(17);
        root.right.left = new Node(12);
        root.right.right = new Node(19);
        root.right.right.right = new Node(1);


        boolean result = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("result isBST" + result);


    }

}
