package binarytree;

public class MorisInOrderTreeTravesal {

	
	
	/*
     * 1. Initialize current as root
   2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost 
         node in current's left subtree
      b) Go to this left child, i.e., current = current->left
	 */

    public static void MorrisTraversal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
	                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
	                 
	                /* Make current as right child of its inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }
	  
	                 /* Revert the changes made in if part to restore the 
	                    original tree i.e.,fix the right child of predecssor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */

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

        IterativeInOrderTraversal.inOrder(root);
        System.out.println("Moris inorder tree traversal");
        MorrisTraversal(root);

    }

}
