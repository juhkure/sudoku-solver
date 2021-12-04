package sanakirja;

import sanakirja.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juhku
 */
public class Dictionary {

    private Trie dictionary;
    private ArrayList<String> dictionaryWords;

    public Dictionary() {
        this.dictionary = new Trie();
        dictionaryWords = new ArrayList<>();
    }

    public String check(String repairable) {
        String[] words = repairable.split(" ");
        String repaired = "";
        for (String word : words) {
            if (!dictionary.containsWord(word)) {
                word = fix(word);
            }
            repaired += word + " ";
        }

        return repaired;
    }

    private String fix(String word) {
        int distance = 1000;

        System.out.println(word);
        return word;
    }

    public void prepareDictionary() {
        int counter = 0;
        try {
            Scanner reader = new Scanner(new File("src/resources/words.txt"));

            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                dictionary.add(word);
                dictionaryWords.add(word);
                counter++;
                if (counter % 1000 == 0) {
                    System.out.println(counter);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
