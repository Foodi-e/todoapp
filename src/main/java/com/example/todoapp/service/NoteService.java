package com.example.todoapp.service;

import com.example.todoapp.dto.NoteDto;
import com.example.todoapp.entity.Note;
import com.example.todoapp.exception.ItemNotFoundException;
import com.example.todoapp.mapper.Mapper;
import com.example.todoapp.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final Mapper mapper;

    public NoteDto get(Long id){
        return noteRepository.findById(id).map(mapper::toDto).orElseThrow(() -> new ItemNotFoundException(Note.class, id));
    }

    public void delete(Long id){
        noteRepository.deleteById(id);
    }

    public void update(Long id, NoteDto noteDto){
        Note note = noteRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(Note.class, id));
        mapper.merge(noteDto, note);
        noteRepository.save(note);
    }

    public List<NoteDto> getAll(){
        return noteRepository.findAll().stream().map(mapper::toDto).toList();
    }
}
