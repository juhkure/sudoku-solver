package sanakirja;

import java.util.HashMap;

/**
 *
 * @author juhku
 */
public class Trie {

    private TrieNode root;
    static final int ALPHABET_SIZE = 26;

    public Trie() {
        this.root = new TrieNode();
    }

    public void add(String word) {
        TrieNode current = root;

        for (char s : word.toLowerCase().toCharArray()) {
            HashMap<Character, TrieNode> children = current.getChildren();
            if (children.containsKey(s)){
                current = children.get(s);
            } else {
                children.put(s, new TrieNode());
                current = children.get(s);
            }
            
//            current = current.getChildren().computeIfAbsent(s, c -> new TrieNode());
//            current.getChildren().computeif
        }

        current.setWordEnd(true);

    }
    
    
    public void add2(String key){
        int level;
        int length = key.length();
        int index;
        
        TrieNode pCrawl = root;
    }
    

    public boolean remove(String word) {
        return remove(root, word, 0);
    }

    private boolean remove(TrieNode current, String word, int i) {
        if (i == word.length()) {
            if (!current.isWordEnd()) {
                return false;
            }

            current.setWordEnd(false);
            return current.getChildren().isEmpty();
        }

        char c = word.charAt(i);
        TrieNode node = current.getChildren().get(c);

        if (node == null) {
            return false;
        }

        boolean removeCurrentNode = remove(node, word, i + 1) && !node.isWordEnd();

        if (removeCurrentNode) {
            current.getChildren().remove(c);
            return current.getChildren().isEmpty();
        }

        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean containsWord(String word) {
        word = word.toLowerCase();
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
//            System.out.println(c);
            TrieNode node = current.getChildren().get(c);

            if (node == null) {
                return false;
            }

            current = node;
        }
        
        System.out.println(current.isWordEnd());
//        System.out.println(String.join(",",current.getChildren().keySet().toArray()));
        
//        for (Character character : current.getChildren().keySet()) {
//            System.out.println(character);
//            
//        }

        return current.isWordEnd();
    }

}
