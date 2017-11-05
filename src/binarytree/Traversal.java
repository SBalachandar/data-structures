package binarytree;


public class Traversal {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Node root = new Node(10);
        root.left = new Node(12);
        root.left.left = new Node(14);
        root.left.right = new Node(19);

        root.left.left.left = new Node(16);
        root.left.left.right = new Node(18);

        root.right = new Node(13);
        root.right.right = new Node(15);

		/*
		 *      10
		 *    12    13
		 *  14  19    15
		 * 16 18
		 */
        Traversal traversal = new Traversal();
        System.out.println("\n preOrder ");
        traversal.preOrder(root);

        System.out.println("\n Inorder traversal  ");
        traversal.inOrder(root);

        System.out.println("\n postOrder traversal ");
        traversal.postOrder(root);

        System.out.println("\n height tree " + traversal.height(root));

        System.out.println("\n levelOrder 1 ");
        traversal.levelOrder(root);

    }

    //V L R
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(" " + node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(" " + node.data);
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(" " + node.data);
    }

    public int height(Node node) {
        if (node == null) return 0;

        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;

        if (leftHeight > rightHeight) {
            return leftHeight;
        } else {
            return rightHeight;
        }
    }

    private void printLevel(Node node, int level) {
        if (node == null) return;

        if (level == 1) {
            System.out.print(" " + node.data);
        } else if (level > 1) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }

    public void levelOrder(Node node) {
        int ht = height(node);
        for (int i = 1; i <= ht; i++) {
            printLevel(node, i);
        }
    }

}
