package binarytree;

public class SerialIzeBinaryTree {

    public SerialIzeBinaryTree() {
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SerialIzeBinaryTree sbt = new SerialIzeBinaryTree();
        Node node = new Node(10);
        node.left = new Node(12);
        node.left.left = new Node(14);
        node.left.right = new Node(19);

        node.left.left.left = new Node(16);
        node.left.left.right = new Node(18);

        node.right = new Node(13);
        node.right.right = new Node(15);

		/*
		 *      10
		 *    12    13
		 *  14  19    15
		 * 16 18
		 */

        System.out.println("preOrder ");
        sbt.preOrder(node);
        String str = sbt.serialize(node);
        System.out.println("  serialize11 " + str);
        Node node1 = sbt.deserialize(str);
        System.out.println("after deserailze ");
        sbt.preOrder(node1);


    }

    public String serialize(Node node) {
        StringBuilder sb = new StringBuilder();
        return serialize(node, sb);
    }

    public String serialize(Node node, StringBuilder sb) {
        if (node == null)
            sb.append("# ");
        else {
            sb.append(node.data + " ");
            serialize(node.left, sb);
            serialize(node.right, sb);
        }

        return sb.toString();
    }

    public Node deserialize(String str) {
        if (str == null || str.length() == 0) return null;
        StringTokenizer tokens = new StringTokenizer(str, " ");
        return deserialize(tokens);
    }

    public Node deserialize(StringTokenizer tokens) {
        if (!tokens.hasMoreTokens()) return null;

        String token = tokens.nextToken();
        if (token.equals("#")) {
            return null;
        }
        Node root = new Node(Integer.parseInt(token));
        root.left = deserialize(tokens);
        root.right = deserialize(tokens);

        return root;
    }

    public void preOrder(Node node) {
        if (node == null) return;

        System.out.print(" " + node.data);
        if (node.left != null) preOrder(node.left);
        if (node.right != null) preOrder(node.right);

    }

}
