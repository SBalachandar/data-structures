package binarytree;

import java.util.ArrayList;
import java.util.List;


public class RootToLeafSum {

    public static boolean rootToLeafSum(Node root, int sum, List<Integer> result) {

        //edge cases
        if (root == null) return false;

        //Leaf node
        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                result.add(root.data);
                return true;
            } else {
                return false;
            }
        }

        //NonLeaf Nodes

        if (rootToLeafSum(root.left, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }

        if (rootToLeafSum(root.right, sum - root.data, result)) {
            result.add(root.data);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

		/*
		 *       16
		 *     10   5
		 *      -3 8 5
		 *      
		 *      need to return true and List[16,5,5]
		 */

        Node root = new Node(16);
        root.left = new Node(10);
        root.right = new Node(5);
        root.left.right = new Node(-3);
        root.right.left = new Node(8);
        root.right.right = new Node(5);

        List<Integer> result = new ArrayList<Integer>();
        boolean r = rootToLeafSum(root, 26, result);
        System.out.println("r " + r + " result " + result);


    }

}
