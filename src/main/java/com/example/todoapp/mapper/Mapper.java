package com.example.todoapp.mapper;

import com.example.todoapp.dto.NoteDto;
import com.example.todoapp.entity.Note;
import org.mapstruct.MappingTarget;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    Note toEntity(NoteDto note);
    NoteDto toDto(Note note);

    void merge(NoteDto noteDto, @MappingTarget Note note);
}
