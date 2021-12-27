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

        Dictionary dictionary = new Dictionary();
        dictionary.prepareDictionary();

        System.out.println("Correctable text: ");

        Scanner scanner = new Scanner(System.in);
        String repairable = scanner.nextLine();
        
        Long startTime = System.nanoTime();
        

        String repaired = dictionary.check(repairable);
        
        Long stopTime = System.nanoTime();

        System.out.println("\nCorrected version: ");
        System.out.println(repaired);
        
        System.out.println("Time passed: " + (double)(stopTime - startTime)/1000000000 + " seconds");

    }

}
