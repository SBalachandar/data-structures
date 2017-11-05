package trie;

class TrieNode {
    char c;
    Map<Character, TrieNode> children = new HashMap<>();
    boolean leaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode t = null;
            if (children.containsKey(ch)) {
                t = children.get(ch);
            } else {
                t = new TrieNode(ch);
                children.put(ch, t);
            }
            children = t.children;

            //set leaf node

            if (i == word.length() - 1) {
                t.leaf = true;
            }
        }
    }

    public TrieNode search(String word) {
        Map<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (children.containsKey(ch)) {
                TrieNode node = children.get(ch);
                children = node.children;

            } else {
                return null;
            }
        }

        return null;
    }

}
