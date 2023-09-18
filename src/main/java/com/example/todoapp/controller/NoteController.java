package com.example.todoapp.controller;

import com.example.todoapp.dto.NoteDto;
import com.example.todoapp.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;


@RestController
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getAll() {
        List<NoteDto> notes = noteService.getAll();
        ModelAndView noteList = new ModelAndView("note/list");
        noteList.addObject("notes", notes);
        return noteList;
    }

    @PostMapping("/delete")
    public RedirectView deleteNote(@RequestParam("id") Long id) {
        RedirectView redirectView = new RedirectView("/note/list");
        noteService.delete(id);
        return redirectView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editView(@PathVariable("id") Long id){
        ModelAndView noteEdit = new ModelAndView("note/edit");
        noteEdit.addObject("note", noteService.get(id));
        return noteEdit;
    }

    @PostMapping("/edit")
    public RedirectView update(@ModelAttribute NoteDto noteDto){
        RedirectView redirectView = new RedirectView("/note/list");
        noteService.update(noteDto.getId(), noteDto);
        return redirectView;
    }
}
