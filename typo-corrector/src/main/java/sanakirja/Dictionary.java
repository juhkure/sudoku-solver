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

    /*
        Checks if words are included in dictionary, forwards unrecognized words to fix() if not
     */
    public String check(String repairable) {
        //first splits the inputted string of text into separated words
        String[] words = repairable.split(" ");
        String repaired = "";
        for (String word : words) {

            //checks if word ends with punctuation mark
            char lastChar = word.charAt(word.length() - 1);
            boolean isPunctuationMark = false;
            if (lastChar == '!' || lastChar == '.' || lastChar == '?' || lastChar == ',') {
                word = word.substring(0, word.length() - 1);
                isPunctuationMark = true;
            }

            if (!dictionary.containsWord(word)) {
                word = fix(word);
            }

            //adds the formerly removed punctuation mark
            if (isPunctuationMark) {
                repaired += word + lastChar + " ";
            } else {
                repaired += word + " ";
            }
        }

        return repaired.trim();
    }

    /*
        Receives a word that's unrecognized, loops it against all dictionary's words with distance() taking the lowest distance and returning it
     */
    public String fix(String word) {
        int lowestDistance = Integer.MAX_VALUE;
        String fixedWord = "";

        for (String dictionaryWord : dictionaryWords) {
            int calculatedDistance = distance(word, dictionaryWord);
            if (calculatedDistance < lowestDistance) {
                fixedWord = dictionaryWord;
                lowestDistance = calculatedDistance;
            }
        }

        System.out.println("\nUnrecognized word: " + word);
        System.out.println("Corrected to: " + fixedWord);
        return fixedWord;
    }

    /*
        Damerau-Levenshtein algorithm
     */
    public int distance(String typo, String comparison) {
        int inputLength = typo.length();
        int comparisonLength = comparison.length();

        // Creates a matrix which it uses to calculate the distance between two words.
        int[][] dist = new int[inputLength + 1][comparisonLength + 1];
        for (int i = 0; i < inputLength + 1; i++) {
            dist[i][0] = i;
        }
        for (int j = 0; j < comparisonLength + 1; j++) {
            dist[0][j] = j;
        }

        // Loops all cells in the matrix
        for (int i = 1; i < inputLength + 1; i++) {
            for (int j = 1; j < comparisonLength + 1; j++) {

                int cost;
                if (typo.charAt(i - 1) == comparison.charAt(j - 1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                // checks the minimums for        deletion            insertion          substitution
                dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);
                // checks the minimum for transposition
                if (i > 1 && j > 1 && typo.charAt(i - 1) == comparison.charAt(j - 2) && typo.charAt(i - 2) == comparison.charAt(j - 1)) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);
                }
            }
        }

        // Returns the final cell in the matrix
        return dist[inputLength][comparisonLength];
    }

    /*
        Adds all words from the source file to a list
     */
    public void prepareDictionary() {
        try {
            Scanner reader = new Scanner(new File("src/resources/words.txt"));

            while (reader.hasNextLine()) {
                String word = reader.nextLine();
                dictionary.add(word);
                dictionaryWords.add(word);
            }

            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
