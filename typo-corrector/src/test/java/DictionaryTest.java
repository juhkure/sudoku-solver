
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.*;
import sanakirja.Trie;
import sanakirja.TrieNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author juhku
 */
public class DictionaryTest {

    @Test
    public void addWordWorks() {
        Trie trie = new Trie();

        trie.add("testing");

        assertTrue(trie.containsWord("testing"));
    }
}
