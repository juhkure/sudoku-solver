package sanakirja;

import java.util.HashMap;

/**
 *
 * @author juhku
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    /*
        Adds the word to the Trie by traversing the Trie char by char as far as possible and then adding remaining chars to the end of the Trie.
    */
    public void add(String word) {
        TrieNode current = root;

        for (char s : word.toLowerCase().toCharArray()) {
            HashMap<Character, TrieNode> children = current.getChildren();
            if (children.containsKey(s)) {
                current = children.get(s);
            } else {
                children.put(s, new TrieNode());
                current = children.get(s);
            }
        }

        current.setWordEnd(true);
    }

   
    public boolean isEmpty() {
        return root == null;
    }
    
    /*
        Traverses the Trie trying to find matching path with inputted word
    */
    public boolean containsWord(String word) {
        word = word.toLowerCase();
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node = current.getChildren().get(c);

            if (node == null) {
                return false;
            }

            current = node;
        }
        return current.isWordEnd();
    }

}
