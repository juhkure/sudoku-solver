package typo.corrector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import sanakirja.*;

/**
 *
 * @author juhku
 */
public class Main {

    public static void main(String[] args) {
        // Trie trie = new Trie();
        //
        // trie.lisaa("hi");
        // trie.lisaa("how");
        // trie.lisaa("are");
        // trie.lisaa("you");
        //
        // if (trie.sisaltaaSanan("you")) {
        // System.out.println("sisaltaa");
        // } else {
        // System.out.println("ei sisalla");
        // }
        //
        // trie.poista("on");
        //
        // if (trie.sisaltaaSanan("on")) {
        // System.out.println("sisaltaa");
        // } else {
        // System.out.println("ei sisalla");
        // }
        //
        // System.out.println("projekti toimii! (kai...)");
        // System.out.println("");

        // Trie sanakirja = new Trie();
        //
        // Scanner lukija = new Scanner(new File("src/resources/words.txt"));
        //
        // while (lukija.hasNextLine()) {
        // sanakirja.lisaa(lukija.nextLine());
        // }
        //
        Dictionary dictionary = new Dictionary();
        dictionary.prepareDictionary();

        String repairable = "hi how are you today how you're your";
        String repaired = dictionary.check(repairable);

        System.out.println(repaired);

    }

}
