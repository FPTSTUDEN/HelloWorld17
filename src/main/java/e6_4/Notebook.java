package e6_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Notebook {
    // ObservableList allows the ListView to auto-update when notes change
    private final ObservableList<Note> notes;

    public Notebook() {
        this.notes = FXCollections.observableArrayList();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }

    public ObservableList<Note> getNotes() {
        return notes;
    }
}