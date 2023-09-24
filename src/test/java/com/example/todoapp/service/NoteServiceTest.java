package com.example.todoapp.service;

import com.example.todoapp.dto.NoteDto;
import com.example.todoapp.entity.Note;
import com.example.todoapp.exception.ItemNotFoundException;
import com.example.todoapp.mapper.Mapper;
import com.example.todoapp.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceTest {
  @Mock
  private NoteRepository noteRepository;

  @Mock
  private Mapper mapper;

  @InjectMocks
  private NoteService noteService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testGetNoteById() {
    Long id = 1L;
    Note mockNote = new Note();
    NoteDto expectedNoteDto = new NoteDto();

    when(noteRepository.findById(id)).thenReturn(Optional.of(mockNote));
    when(mapper.toDto(mockNote)).thenReturn(expectedNoteDto);

    NoteDto result = noteService.get(id);

    assertEquals(expectedNoteDto, result);
    verify(noteRepository, times(1)).findById(id);
    verify(mapper, times(1)).toDto(mockNote);
  }

  @Test
  public void testGetNoteByIdNotFound() {
    Long id = 1L;

    when(noteRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(ItemNotFoundException.class, () -> noteService.get(id));
  }

  @Test
  public void testDeleteNote() {
    Long id = 1L;

    noteService.delete(id);

    verify(noteRepository, times(1)).deleteById(id);
  }

  @Test
  public void testUpdateNote() {
    Long id = 1L;
    NoteDto updatedNoteDto = new NoteDto();
    Note existingNote = new Note();

    when(noteRepository.findById(id)).thenReturn(Optional.of(existingNote));

    doNothing().when(mapper).merge(updatedNoteDto, existingNote);

    noteService.update(id, updatedNoteDto);

    verify(noteRepository, times(1)).save(existingNote);
  }


  @Test
  public void testGetAllNotes() {
    List<Note> mockNotes = Arrays.asList(new Note(), new Note());
    List<NoteDto> expectedNoteDtos = Arrays.asList(new NoteDto(), new NoteDto());

    when(noteRepository.findAll()).thenReturn(mockNotes);
    when(mapper.toDto(any(Note.class))).thenReturn(expectedNoteDtos.get(0), expectedNoteDtos.get(1));

    List<NoteDto> result = noteService.getAll();

    assertEquals(expectedNoteDtos, result);
    verify(noteRepository, times(1)).findAll();
    verify(mapper, times(2)).toDto(any(Note.class));
  }

}