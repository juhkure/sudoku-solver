package typo.corrector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import sanakirja.*;

/**
 *
 * @author juhku
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Trie trie = new Trie();

        trie.lisaa("tämä");
        trie.lisaa("on");
        trie.lisaa("testi");
        trie.lisaa("teksti");

        if (trie.sisaltaaSanan("tämä")) {
            System.out.println("sisaltaa");
        } else {
            System.out.println("ei sisalla");
        }

        trie.poista("on");

        if (trie.sisaltaaSanan("on")) {
            System.out.println("sisaltaa");
        } else {
            System.out.println("ei sisalla");
        }
        
        System.out.println("projekti toimii! (kai...)");
        System.out.println("");

        Trie sanakirja = new Trie();
        
        Scanner lukija = new Scanner(new File("src/resources/words.txt"));
        
        while (lukija.hasNextLine()) {
            sanakirja.lisaa(lukija.nextLine());
        }
        
        System.out.println("sanakirja toimii?");
        
        if (sanakirja.sisaltaaSanan("this")){
            System.out.println("sisaltaa sanan 'this' ");
        }
        
        
    }

}
