package com.plamen5kov.jotting;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Note> data = new ArrayList<>();

    private static Repository instance;
    private Repository() {
        //seed
        data.add(new Note("111", "content 1111"));
        data.add(new Note("222", "content 222"));
        data.add(new Note("3333", "content 333"));
        data.add(new Note("4444", "content 444"));
    }

    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<Note> getAllNotes() {
        return this.data;
    }

    public void addNote(Note note) {
        this.data.add(note);
    }

    public void editNote(Note note, int index) {
        this.data.get(index).setTitle(note.getTitle());
        this.data.get(index).setContent(note.getContent());
    }

    public void deleteNote(int index) {
        this.data.remove(index);
    }
}
