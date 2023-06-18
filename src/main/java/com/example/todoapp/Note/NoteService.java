package com.example.todoapp.Note;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();

    public List<Note> listAll(){
        return notes.values().stream().toList();
    }

    private long generateId(){
        Random random = new Random();

        long rand;
        do{
            rand = random.nextLong(Long.MAX_VALUE);
        }while (notes.containsKey(rand));

        return rand;
    }

    public Note add(Note note){
        note.setId(generateId());
        notes.put(note.getId(), note);

        return note;
    }

    public void deleteById(long id){
        notes.remove(id);
    }

    public void update(Note note){
        try {
            notes.get(note.getId());
            notes.put(note.getId(), note);

        } catch (Exception e){
            System.out.println("Note with Id " + note.getId() + "does not exist");
        }
    }

    public Note getById(long id){
        return notes.get(id);
    }
}
