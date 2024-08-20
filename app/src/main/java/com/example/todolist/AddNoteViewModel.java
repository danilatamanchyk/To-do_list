package com.example.todolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class AddNoteViewModel extends AndroidViewModel {

    private NoteDatabase noteDatabase;

    public AddNoteViewModel(@NonNull Application application) {
        super(application);
        noteDatabase = NoteDatabase.getInstance(application);
    }

    public void addNote(Note note) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                noteDatabase.noteDao().add(note);
            }
        });
        thread.start();
    }
}
