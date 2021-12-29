
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sanakirja.Dictionary;

/**
 *
 * @author juhku
 */
public class DictionaryTest {

    private Dictionary dictionary;

    @Before
    public void setup() {
        this.dictionary = new Dictionary();
        dictionary.prepareDictionary();
    }

    /*
        Should return inputted word without changes
     */
    @Test
    public void singleWordWithoutTypo() {
        String output = dictionary.check("example");
        assertTrue(output.equals("example"));
    }

    @Test
    public void multipleWordsWithoutTypos() {
        String output = dictionary.check("example words and stuff");
        assertTrue(output.equals("example words and stuff"));
    }

    @Test
    public void singleWordWithTypo() {
        String output = dictionary.check("exemple");
        assertTrue(output.equals("example"));
    }

    @Test
    public void multipleWordsWithTypos() {
        String output = dictionary.check("tihs is an exemple");
        assertTrue(output.equals("this is an example"));
    }
    
    /*
        Checks if swapping a <-> b yields same result.
    */
    @Test
    public void distanceViceVersa() {
        assertTrue(dictionary.distance("", "aaaaa") == dictionary.distance("aaaaa", ""));
        assertTrue(dictionary.distance("example", "") == dictionary.distance("example", ""));
    }
    
    @Test
    public void distanceCalculatesCorrectly(){
        assertTrue(dictionary.distance("abdicates", "abnormal") == 7);
        assertTrue(dictionary.distance("luopua", "uolupa") == 3);
        assertTrue(dictionary.distance("", "aaaaa") == 5);
        assertTrue(dictionary.distance("thiswordismadeup", "thisismadeup") == 4);
    }
}
