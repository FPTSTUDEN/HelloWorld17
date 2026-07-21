package e6_1;

public class DictionaryController {
    Dictionary dictionary = new Dictionary();
    DictionaryView view;
    public DictionaryController(DictionaryView view) {
        this.view = view;
        // Add event handlers for the buttons in the view
        view.addButton.setOnAction(e -> handleAddWord());
        view.searchButton.setOnAction(e -> handleSearchWord());
    }
    public void handleAddWord() {
        // Logic to add a word to the dictionary
        String word = view.textInput.getText(); // Get text from the text input field
        String definition = view.definitionInput.getText(); // Get text from the definition input field
        dictionary.addWord(word, definition);
        view.resultLabel.setText("Word added: " + word);
    }
    public void handleSearchWord() {
        // Logic to search for a word in the dictionary
        String word = view.textInput.getText(); // Get text from the text input field
        String definition = dictionary.getDefinition(word);
        view.resultLabel.setText(definition != null ? definition : "Word not found");
    }
}
