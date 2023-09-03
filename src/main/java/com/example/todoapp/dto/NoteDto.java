package com.example.todoapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoteDto {
    private long id;
    private String title;
    private String content;
}
