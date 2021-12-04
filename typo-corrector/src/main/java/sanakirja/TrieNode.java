package sanakirja;

import java.util.HashMap;

/**
 *
 * @author juhku
 */
public class TrieNode {

    private final HashMap<Character, TrieNode> children;
    private boolean wordEnd;

    public TrieNode() {
        this.children = new HashMap<>();
//        wordEnd = false;
    }

    public boolean isWordEnd() {
        return wordEnd;
    }

    public HashMap<Character, TrieNode> getChildren() {
//        if (children.isEmpty()) {
//            return null;
//        } else {
            return children;
//        }
    }

    public void setWordEnd(boolean wordEnd) {
        this.wordEnd = wordEnd;
    }
}
