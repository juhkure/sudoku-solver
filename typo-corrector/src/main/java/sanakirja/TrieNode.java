package sanakirja;

import java.util.HashMap;

/**
 *
 * @author juhku
 */
public class TrieNode {

    private final HashMap<Character, TrieNode> lapset;
    private String sisalto;
    private boolean sananLoppu;

    public TrieNode() {
        this.lapset = new HashMap<>();
    }

    public boolean onSananLoppu() {
        return sananLoppu;
    }

    public HashMap<Character, TrieNode> getLapset() {
        return lapset;
    }

    public void setSananLoppu(boolean b) {
        this.sananLoppu = b;
    }
}
