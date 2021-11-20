package sanakirja;

import java.util.HashMap;

/**
 *
 * @author juhku
 */
public class Trie {

    private TrieNode juuri;

    public Trie() {
        this.juuri = new TrieNode();
    }

    public void lisaa(String word) {
        TrieNode nykyinen = juuri;

        for (char s : word.toCharArray()) {
            nykyinen = nykyinen.getLapset().computeIfAbsent(s, c -> new TrieNode());
        }

        nykyinen.setSananLoppu(true);

    }

    public boolean poista(String sana) {
        return poista(juuri, sana, 0);
    }

    private boolean poista(TrieNode nykyinen, String sana, int i) {
        if (i == sana.length()) {
            if (!nykyinen.onSananLoppu()) {
                return false;
            }

            nykyinen.setSananLoppu(false);
            return nykyinen.getLapset().isEmpty();
        }

        char c = sana.charAt(i);
        TrieNode node = nykyinen.getLapset().get(c);

        if (node == null) {
            return false;
        }

        boolean poistaNykyinenNode = poista(node, sana, i + 1) && !node.onSananLoppu();

        if (poistaNykyinenNode) {
            nykyinen.getLapset().remove(c);
            return nykyinen.getLapset().isEmpty();
        }

        return false;
    }

    public boolean isEmpty() {
        return juuri == null;
    }

    public boolean sisaltaaSanan(String sana) {
        TrieNode nykyinen = juuri;

        for (int i = 0; i < sana.length(); i++) {
            char c = sana.charAt(i);
            TrieNode node = nykyinen.getLapset().get(c);

            if (node == null) {
                return false;
            }

            nykyinen = node;
        }

        return nykyinen.onSananLoppu();
    }

}
