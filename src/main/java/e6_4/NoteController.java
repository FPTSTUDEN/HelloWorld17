package e6_4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {

    @FXML private TextField titleField;
    @FXML private TextArea contentArea;
    @FXML private ListView<Note> noteListView;
    @FXML private Button addButton;
    @FXML private Button deleteButton;

    private final Notebook notebook = new Notebook();
    private Note selectedNote = null; // Tracks if a note is currently selected for editing

    @FXML
    public void initialize() {
        // Bind the Notebook data list to the ListView visual representation
        noteListView.setItems(notebook.getNotes());

        // Listen for selection changes in the list view
        // noteListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        //     if (newValue != null) {
        //         selectedNote = newValue;
        //         titleField.setText(selectedNote.getTitle());
        //         contentArea.setText(selectedNote.getContent());
        //         addButton.setText("Update Note");
        //         deleteButton.setVisible(true); // Show delete button when an item is selected
        //     }
        // });
    }

    @FXML
    private void handleAddOrUpdateNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();

        // Prevent saving notes with missing information
        if (title.isEmpty() || content.isEmpty()) {
            return; 
        }

        if (selectedNote == null) {
            // Context: Create a new Note
            Note newNote = new Note(title, content);
            notebook.addNote(newNote);
        } else {
            // Context: Update an existing Note
            selectedNote.setTitle(title);
            selectedNote.setContent(content);
            noteListView.refresh(); // Tells UI to redraw changes
        }

        handleClearFields();
    }

    @FXML
    private void handleDeleteNote() {
        if (selectedNote != null) {
            notebook.deleteNote(selectedNote);
            handleClearFields();
        }
    }

    @FXML
    private void handleClearFields() {
        titleField.clear();
        contentArea.clear();
        noteListView.getSelectionModel().clearSelection();
        selectedNote = null;
        addButton.setText("Save Note");
        deleteButton.setVisible(false);
    }
}
