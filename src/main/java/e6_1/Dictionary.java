package e6_1;
import java.util.HashMap;
public class Dictionary {
    HashMap<String, String> dict = new HashMap<>();
    public void addWord(String word, String definition) {
        dict.put(word, definition);
    }
    public String searchWord(String word) {
        try {
            return dict.get(word);
        } catch (Exception e) {
            return "Word not found.";
        }
    }
    public String getDefinition(String word) {
        return searchWord(word);
    }
}
