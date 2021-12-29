
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import sanakirja.Trie;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juhku
 */
public class TrieTest {

    private Trie trie;

    @Before
    public void setup() {
        trie = new Trie();
    }

    @Test
    public void addWordOneWord() {
        trie.add("testing");

        assertTrue(trie.containsWord("testing"));
    }

    @Test
    public void contains() {
        trie.add("testing");

        assertTrue(trie.containsWord("testing"));
    }

    @Test
    public void addMultipleWords() {
        trie.add("testing");
        trie.add("with");
        trie.add("multiple");
        trie.add("words");

        assertTrue(trie.containsWord("testing"));
        assertTrue(trie.containsWord("with"));
        assertTrue(trie.containsWord("multiple"));
        assertTrue(trie.containsWord("words"));
    }

}
